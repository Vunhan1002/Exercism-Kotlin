class Squares(private val n: Int) {

    fun sumOfSquares(): Int {
        // Công thức n(n+1)(2n+1)/6
        return n * (n + 1) * (2 * n + 1) / 6
    }

    fun squareOfSum(): Int {
        // (n(n+1)/2)^2
        val sum = n * (n + 1) / 2
        return sum * sum
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}
