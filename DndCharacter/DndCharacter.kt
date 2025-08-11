import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int {
            // 4d6 drop lowest: sum - min
            var sum = 0
            var min = Int.MAX_VALUE
            repeat(4) {
                val roll = Random.nextInt(1, 7) // 1..6
                sum += roll
                if (roll < min) min = roll
            }
            return sum - min
        }

        fun modifier(score: Int): Int {
            return Math.floorDiv(score - 10, 2)
        }
    }
}
