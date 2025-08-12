object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        return primeFactors(int.toLong()).map { it.toInt() }
    }

    fun primeFactors(long: Long): List<Long> {
        var n = long
        val factors = mutableListOf<Long>()
        if (n < 2L) return factors

        // Lấy hết thừa số 2
        while (n % 2L == 0L) {
            factors += 2L
            n /= 2L
        }

        // Chỉ thử số lẻ
        var f = 3L
        while (f <= n / f) {
            while (n % f == 0L) {
                factors += f
                n /= f
            }
            f += 2
        }

        // Phần còn lại (nếu > 1) là prime
        if (n > 1L) factors += n

        return factors
    }
}
