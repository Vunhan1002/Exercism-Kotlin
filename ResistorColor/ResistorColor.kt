object ResistorColor {

    private val palette = listOf(
        "black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"
    )

    fun colorCode(input: String): Int = palette.indexOf(input)

    fun colors(): List<String> = palette
}