class ChangeCalculator(val coins: List<Int>) {
    private val sorted = coins.sorted()

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        require(grandTotal >= 0) { "Negative totals are not allowed." }

        var changes = (1..grandTotal).fold(listOf<List<Int>?>(listOf<Int>())){ result, amount ->
            coins
                .filter { result.getOrNull(amount - it) != null }
                .map { listOf(it) + result.get(amount - it)!!  }
                .sortedBy { it.size }
                .firstOrNull()
                .let { result.plusElement(it) }
        }

        return requireNotNull(changes.lastOrNull()) {
            "The total $grandTotal cannot be represented in the given currency.."
        }
    }
}