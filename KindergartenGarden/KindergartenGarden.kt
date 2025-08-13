class KindergartenGarden(private val diagram: String) {

    private val students = listOf(
        "Alice", "Bob", "Charlie", "David", "Eve", "Fred",
        "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"
    )

    private val plantMap = mapOf(
        'G' to "grass",
        'C' to "clover",
        'R' to "radishes",
        'V' to "violets"
    )

    fun getPlantsOfStudent(student: String): List<String> {
        val (row1, row2) = diagram.split('\n')
        val idx = students.indexOf(student)
        require(idx >= 0) { "Unknown student: $student" }

        val start = idx * 2
        val picks = listOf(
            row1[start], row1[start + 1],
            row2[start], row2[start + 1]
        )
        return picks.map { ch -> plantMap[ch] ?: error("Invalid plant code: $ch") }
    }
}
