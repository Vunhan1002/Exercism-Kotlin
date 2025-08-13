class BaseConverter(private val sourceBase: Int, private val digits: IntArray) {

    private val value: Long

    init {
        // Base hợp lệ?
        if (sourceBase < 2) throw IllegalArgumentException("Bases must be at least 2.")
        // Có ít nhất 1 digit?
        if (digits.isEmpty()) throw IllegalArgumentException("You must supply at least one digit.")
        // Không leading zeros trừ khi là số 0 đơn
        if (digits.size > 1 && digits[0] == 0) throw IllegalArgumentException("Digits may not contain leading zeros.")
        // Kiểm tra từng digit
        for (d in digits) {
            if (d < 0) throw IllegalArgumentException("Digits may not be negative.")
            if (d >= sourceBase) throw IllegalArgumentException("All digits must be strictly less than the base.")
        }
        // Tính giá trị theo cơ số nguồn
        var acc = 0L
        for (d in digits) {
            acc = acc * sourceBase + d
        }
        value = acc
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) throw IllegalArgumentException("Bases must be at least 2.")
        // Số 0
        if (value == 0L) return intArrayOf(0)

        var n = value
        val out = ArrayList<Int>()
        while (n > 0) {
            out.add((n % newBase).toInt())
            n /= newBase
        }
        out.reverse()
        return out.toIntArray()
    }
}
