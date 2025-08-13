object Atbash {

    private const val ALPHABET = "abcdefghijklmnopqrstuvwxyz"

    fun encode(s: String): String {
        // Chỉ lấy chữ và số, đưa hết về lowercase
        val clean = s.lowercase().filter { it.isLetterOrDigit() }
        // Mã hóa từng ký tự
        val encoded = clean.map {
            if (it.isLetter()) {
                val index = ALPHABET.indexOf(it)
                ALPHABET[25 - index] // Lật vị trí chữ cái
            } else {
                it // Giữ nguyên số
            }
        }.joinToString("")
        // Chia nhóm 5 ký tự
        return encoded.chunked(5).joinToString(" ")
    }

    fun decode(s: String): String {
        // Bỏ khoảng trắng
        val clean = s.filter { it.isLetterOrDigit() }
        // Giải mã tương tự encode
        return clean.map {
            if (it.isLetter()) {
                val index = ALPHABET.indexOf(it)
                ALPHABET[25 - index]
            } else {
                it
            }
        }.joinToString("")
    }
}
