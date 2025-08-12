object RunLengthEncoding {

    fun encode(input: String): String {
        if (input.isEmpty()) return ""
        val sb = StringBuilder()
        var count = 1
        for (i in 1..input.length) {
            if (i < input.length && input[i] == input[i - 1]) {
                count++
            } else {
                if (count > 1) sb.append(count)
                sb.append(input[i - 1])
                count = 1
            }
        }
        return sb.toString()
    }

    fun decode(input: String): String {
        if (input.isEmpty()) return ""
        val sb = StringBuilder()
        var countStr = ""
        for (ch in input) {
            if (ch.isDigit()) {
                countStr += ch
            } else {
                val count = if (countStr.isEmpty()) 1 else countStr.toInt()
                repeat(count) { sb.append(ch) }
                countStr = ""
            }
        }
        return sb.toString()
    }
}
