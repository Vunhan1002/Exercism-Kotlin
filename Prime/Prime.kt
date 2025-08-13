object Prime {

    fun nth(n: Int): Int {
        if (n < 1) throw IllegalArgumentException("There is no zeroth prime.")
        
        var count = 0
        var candidate = 1
        while (count < n) {
            candidate++
            if (isPrime(candidate)) {
                count++
            }
        }
        return candidate
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        if (num == 2) return true
        if (num % 2 == 0) return false
        val limit = Math.sqrt(num.toDouble()).toInt()
        for (i in 3..limit step 2) {
            if (num % i == 0) return false
        }
        return true
    }
}
