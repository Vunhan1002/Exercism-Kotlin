object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        require(dices.size == 5) { "Need exactly 5 dice" }

        val cnt = IntArray(7) // đếm mặt 1..6
        var sum = 0
        for (d in dices) {
            cnt[d]++
            sum += d
        }

        return when (category) {
            YachtCategory.ONES   -> 1 * cnt[1]
            YachtCategory.TWOS   -> 2 * cnt[2]
            YachtCategory.THREES -> 3 * cnt[3]
            YachtCategory.FOURS  -> 4 * cnt[4]
            YachtCategory.FIVES  -> 5 * cnt[5]
            YachtCategory.SIXES  -> 6 * cnt[6]

            YachtCategory.YACHT -> if (cnt.any { it == 5 }) 50 else 0

            YachtCategory.FULL_HOUSE -> {
                val hasThree = cnt.any { it == 3 }
                val hasTwo   = cnt.any { it == 2 }
                if (hasThree && hasTwo) sum else 0
            }

            YachtCategory.FOUR_OF_A_KIND -> {
                val face = (1..6).firstOrNull { cnt[it] >= 4 }
                if (face != null) 4 * face else 0
            }

            YachtCategory.LITTLE_STRAIGHT ->
                if ((1..5).all { cnt[it] == 1 } && cnt[6] == 0) 30 else 0

            YachtCategory.BIG_STRAIGHT ->
                if ((2..6).all { cnt[it] == 1 } && cnt[1] == 0) 30 else 0

            YachtCategory.CHOICE -> sum
        }
    }
}
