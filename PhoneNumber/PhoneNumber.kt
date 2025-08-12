class PhoneNumber(raw: String) {

    val number: String

    init {
        // 1) Giữ lại chữ số
        val digitsOnly = raw.filter { it.isDigit() }

        // 2) Xử lý mã quốc gia
        val tenDigits = when {
            digitsOnly.length == 11 && digitsOnly.first() == '1' -> digitsOnly.drop(1)
            digitsOnly.length == 10 -> digitsOnly
            digitsOnly.length == 11 -> throw IllegalArgumentException()
            else -> throw IllegalArgumentException()
        }

        // 3) Kiểm tra area code và exchange code
        if (tenDigits[0] !in '2'..'9') throw IllegalArgumentException() // area code
        if (tenDigits[3] !in '2'..'9') throw IllegalArgumentException() // exchange code

        number = tenDigits
    }
}
