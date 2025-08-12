enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber <= 0) {
        throw RuntimeException()
    }

    val sum = (1 until naturalNumber).filter { naturalNumber % it == 0 }.sum()

    return when {
        sum == naturalNumber -> Classification.PERFECT
        sum > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}
