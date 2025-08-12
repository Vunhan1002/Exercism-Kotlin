enum class Relationship {
    EQUAL, SUBLIST, SUPERLIST, UNEQUAL
}

// Extension cho List<T>
fun <T> List<T>.relationshipTo(other: List<T>): Relationship {
    if (this == other) return Relationship.EQUAL
    if (this.isSublistOf(other)) return Relationship.SUBLIST
    if (other.isSublistOf(this)) return Relationship.SUPERLIST
    return Relationship.UNEQUAL
}

private fun <T> List<T>.isSublistOf(big: List<T>): Boolean {
    val small = this
    if (small.isEmpty()) return true
    if (small.size > big.size) return false
    for (i in 0..big.size - small.size) {
        if (big.subList(i, i + small.size) == small) return true
    }
    return false
}
