class Matrix(private val matrixAsString: String) {

    private val rows: List<List<Int>> = matrixAsString
        .trim()
        .lines()
        .map { it.trim().split(Regex("\\s+")).map(String::toInt) }

    fun row(rowNr: Int): List<Int> = rows[rowNr - 1]

    fun column(colNr: Int): List<Int> = rows.map { it[colNr - 1] }
}
