class School {

    // grade -> danh sách tên đã sắp xếp alphabet
    private val byGrade: java.util.SortedMap<Int, java.util.SortedSet<String>> =
        java.util.TreeMap()

    // để phát hiện trùng tên (một học sinh chỉ được thêm 1 lần)
    private val allNames = mutableSetOf<String>()

    fun add(student: String, grade: Int) {
        if (student in allNames) {
            throw IllegalArgumentException("Student already enrolled: $student")
        }
        val set = byGrade.getOrPut(grade) { java.util.TreeSet() }
        set.add(student)
        allNames.add(student)
    }

    fun grade(grade: Int): List<String> {
        return byGrade[grade]?.toList() ?: emptyList()
    }

    fun roster(): List<String> {
        // duyệt grade tăng dần, trong mỗi grade tên đã là TreeSet nên sẵn sorted
        val result = mutableListOf<String>()
        for ((_, names) in byGrade) {
            result.addAll(names)
        }
        return result
    }
}
