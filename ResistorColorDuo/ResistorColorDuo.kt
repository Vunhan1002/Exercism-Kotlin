object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val firstTwo = colors.take(2).map { it.ordinal }
        return firstTwo[0] * 10 + firstTwo[1]
    }
}
