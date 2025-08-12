object WordCount {

    private val token = Regex("[a-z0-9]+(?:'[a-z0-9]+)?")

    fun phrase(phrase: String): Map<String, Int> {
        val words = token.findAll(phrase.lowercase()).map { it.value }
        return words.groupingBy { it }.eachCount()
    }
}
