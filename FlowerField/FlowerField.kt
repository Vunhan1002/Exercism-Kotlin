class FlowerFieldBoard(private val input: List<String>) {

    fun withNumbers(): List<String> {
        if (input.isEmpty()) return emptyList()

        val rows = input.size
        val out = ArrayList<String>(rows)

        for (r in 0 until rows) {
            val cols = input[r].length
            val rowChars = CharArray(cols)
            for (c in 0 until cols) {
                val ch = input[r][c]
                if (ch == '*') {
                    rowChars[c] = '*'
                } else {
                    val count = countNeighbors(r, c)
                    rowChars[c] = if (count == 0) ' ' else ('0'.code + count).toChar()
                }
            }
            out += String(rowChars)
        }
        return out
    }

    private fun countNeighbors(r: Int, c: Int): Int {
        var cnt = 0
        for (dr in -1..1) {
            for (dc in -1..1) {
                if (dr == 0 && dc == 0) continue
                val nr = r + dr
                val nc = c + dc
                if (nr in input.indices) {
                    val rowLen = input[nr].length
                    if (nc in 0 until rowLen) {
                        if (input[nr][nc] == '*') cnt++
                    }
                }
            }
        }
        return cnt
    }
}
