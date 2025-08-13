class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val s = number.replace("-", "")
        if (s.length != 10) return false

        var sum = 0
        for (i in 0 until 10) {
            val c = s[i]
            val value = when {
                i == 9 && c == 'X' -> 10
                c.isDigit() -> c - '0'
                else -> return false // ký tự cấm, hoặc 'X' không ở cuối
            }
            sum += value * (10 - i)
        }
        return sum % 11 == 0
    }
}
