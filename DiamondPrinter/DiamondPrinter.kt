class DiamondPrinter {

    fun printToList(ch: Char): List<String> {
        val n = ch - 'A'
        val rows = mutableListOf<String>()

        for (k in 0..n) {
            val lead = n - k
            val letter = ('A' + k)
            val line = buildString {
                append(" ".repeat(lead))
                if (k == 0) {
                    append(letter)
                } else {
                    append(letter)
                    append(" ".repeat(2 * k - 1))
                    append(letter)
                }
                append(" ".repeat(lead))
            }
            rows += line
        }

        for (k in n - 1 downTo 0) {
            rows += rows[k]
        }
        return rows
    }
}
