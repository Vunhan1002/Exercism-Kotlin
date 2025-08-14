object MatchingBrackets {

    private val brackets = mapOf('[' to ']', '(' to ')', '{' to '}')

    private fun open(p: Pair<Boolean, List<Char>>, c: Char): Pair<Boolean, List<Char>> =
        Pair(p.first, p.second.plus(c))

    private fun close(p: Pair<Boolean, List<Char>>, c: Char): Pair<Boolean, List<Char>> {
        val valid = p.second.isNotEmpty() && brackets[p.second.last()] == c
        return Pair(valid, if (valid) p.second.dropLast(1) else listOf())
    }

    fun isValid(input: String): Boolean =
        input.fold(Pair(true, listOf<Char>())) { acc, c ->
            when {
                acc.first && c in brackets.keys -> open(acc, c)
                acc.first && c in brackets.values -> close(acc, c)
                else -> acc
            }
        }.let { it.first && it.second.isEmpty() }

}