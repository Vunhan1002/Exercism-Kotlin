object Acronym {
    fun generate(phrase: String): String {
        // Dấu gạch ngang là phân cách từ → thay bằng khoảng trắng
        val cleaned = phrase.replace("-", " ")
            // Loại bỏ toàn bộ ký tự không phải chữ cái hoặc số hoặc khoảng trắng
            .replace(Regex("[^A-Za-z0-9\\s]"), "")

        // Lấy chữ cái đầu tiên của mỗi từ rồi viết hoa
        return cleaned.split("\\s+".toRegex())
            .filter { it.isNotEmpty() }
            .map { it[0].uppercaseChar() }
            .joinToString("")
    }
}
