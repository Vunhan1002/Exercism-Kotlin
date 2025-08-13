class Series(private val input: String) {

    private val digits: List<Int>

    init {
        if (input.any { !it.isDigit() }) throw IllegalArgumentException()
        digits = input.map { it - '0' }
    }

    fun getLargestProduct(span: Int): Long {
        if (span < 0) throw IllegalArgumentException()
        if (span == 0) return 1
        if (span > digits.size) throw IllegalArgumentException()

        var best = 0L
        for (i in 0..digits.size - span) {
            var prod = 1L
            var zero = false
            for (j in 0 until span) {
                val d = digits[i + j]
                if (d == 0) { zero = true; break }
                prod *= d
            }
            if (!zero) {
                if (prod > best) best = prod
            } else {
                // nếu có 0 trong cửa sổ, tích = 0 → chỉ cần so với best hiện tại
                if (best == 0L) continue
            }
        }
        // Trường hợp toàn số 0 trong mọi cửa sổ → best vẫn 0
        return best
    }
}
