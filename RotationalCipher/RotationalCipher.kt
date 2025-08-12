class RotationalCipher(private val shift: Int) {

    fun encode(text: String): String {
        return text.map { ch ->
            when {
                ch in 'a'..'z' -> {
                    val base = 'a'.code
                    ((ch.code - base + shift) % 26 + base).toChar()
                }
                ch in 'A'..'Z' -> {
                    val base = 'A'.code
                    ((ch.code - base + shift) % 26 + base).toChar()
                }
                else -> ch
            }
        }.joinToString("")
    }
}
