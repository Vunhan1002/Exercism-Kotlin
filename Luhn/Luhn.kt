object Luhn {

    fun isValid(candidate: String): Boolean {
        // cho phép space, cấm ký tự khác
        if (candidate.any { !(it.isDigit() || it == ' ') }) return false

        val digits = candidate.replace(" ", "")
        if (digits.length <= 1) return false

        var sum = 0
        var posFromRight = 0
        for (ch in digits.reversed()) {
            val d = ch - '0'
            val v = if (posFromRight % 2 == 1) {
                val doubled = d * 2
                if (doubled > 9) doubled - 9 else doubled
            } else d
            sum += v
            posFromRight++
        }
        return sum % 10 == 0
    }
}
