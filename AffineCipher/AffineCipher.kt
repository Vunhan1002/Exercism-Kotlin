object AffineCipher {

    private const val M = 26

    private fun gcd(a: Int, b: Int): Int {
        var x = if (a >= 0) a else -a
        var y = if (b >= 0) b else -b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }

    private fun mod(x: Int, m: Int): Int {
        val r = x % m
        return if (r < 0) r + m else r
    }

    private fun mmi(a: Int, m: Int = M): Int? {
        val aa = mod(a, m)
        for (x in 1 until m) if ((aa * x) % m == 1) return x
        return null
    }

    fun encode(input: String, a: Int, b: Int): String {
        if (gcd(a, M) != 1) throw IllegalArgumentException("a and m must be coprime.")

        val aa = mod(a, M)
        val bb = mod(b, M)

        val out = StringBuilder()
        var groupLen = 0

        for (ch in input.lowercase()) {
            when {
                ch in 'a'..'z' -> {
                    val i = ch.code - 'a'.code
                    val enc = (aa * i + bb) % M
                    out.append(('a'.code + enc).toChar())
                    groupLen++
                }
                ch.isDigit() -> {
                    out.append(ch)   // digits kept as-is
                    groupLen++
                }
                else -> { /* ignore punctuation/space */ }
            }
            if (groupLen == 5) {
                out.append(' ')
                groupLen = 0
            }
        }
        return out.toString().trimEnd()
    }

    fun decode(input: String, a: Int, b: Int): String {
        if (gcd(a, M) != 1) throw IllegalArgumentException("a and m must be coprime.")

        val inv = mmi(a) ?: throw IllegalArgumentException("a and m must be coprime.")
        val bb = mod(b, M)

        val out = StringBuilder()
        for (ch in input.lowercase()) {
            when {
                ch in 'a'..'z' -> {
                    val y = ch.code - 'a'.code
                    val dec = mod(inv * (y - bb), M)
                    out.append(('a'.code + dec).toChar())
                }
                ch.isDigit() -> out.append(ch)
                else -> { /* ignore spaces and punctuation */ }
            }
        }
        return out.toString()
    }
}
