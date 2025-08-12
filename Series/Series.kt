object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        if (n <= 0) throw IllegalArgumentException("slice length must be positive")
        if (s.isEmpty()) throw IllegalArgumentException("series must not be empty")
        if (n > s.length) throw IllegalArgumentException("slice length too large")

        val res = ArrayList<List<Int>>(s.length - n + 1)
        for (i in 0..s.length - n) {
            val slice = s.substring(i, i + n).map { it.digitToInt() }
            res += slice
        }
        return res
    }
}
