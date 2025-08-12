object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val actions = mutableListOf<Signal>()

        if (number and 1 != 0) actions += Signal.WINK
        if (number and 2 != 0) actions += Signal.DOUBLE_BLINK
        if (number and 4 != 0) actions += Signal.CLOSE_YOUR_EYES
        if (number and 8 != 0) actions += Signal.JUMP

        if (number and 16 != 0) actions.reverse()

        return actions
    }
}
