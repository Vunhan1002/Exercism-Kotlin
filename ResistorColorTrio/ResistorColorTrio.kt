import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val baseValue = input[0].ordinal * 10 + input[1].ordinal
        val value = (baseValue * 10.0.pow(input[2].ordinal)).toLong()

        val units = listOf("ohms", "kiloohms", "megaohms", "gigaohms")
        var num = value.toDouble()
        var unitIndex = 0

        while (num >= 1000 && unitIndex < units.lastIndex) {
            num /= 1000
            unitIndex++
        }

        val display = if (num % 1 == 0.0) num.toInt().toString() else num.toString()
        return "$display ${units[unitIndex]}"
    }
}
