package Sieve

fun Int.exclusiveMultiples() =
        generateSequence(this * 2) { it + this }

fun primesUpTo(limit: Int): List<Int> {
    val marked = BooleanArray(limit + 1)

    // Numbers above the square root of the limit
    // already have all their multiples marked.
    val divisorLimit = Math.sqrt(limit.toDouble())

    return (2..limit).filter { primeCandidate ->
        if (primeCandidate < divisorLimit) {
            // Mark multiples
            primeCandidate
                    .exclusiveMultiples()
                    .takeWhile { it <= limit }
                    .forEach { marked[it] = true }
        }

        !marked[primeCandidate]
    }
}