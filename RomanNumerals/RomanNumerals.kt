object RomanNumerals {

    private val values = intArrayOf(
        1000, 900, 500, 400,
        100,  90,  50,  40,
        10,    9,   5,   4,
        1
    )

    private val symbols = arrayOf(
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    )

    fun value(n: Int): String {
        var num = n
        val sb = StringBuilder()
        for (i in values.indices) {
            while (num >= values[i]) {
                sb.append(symbols[i])
                num -= values[i]
            }
        }
        return sb.toString()
    }
}
