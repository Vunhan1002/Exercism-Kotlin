class Robot(
    var gridPosition: GridPosition = GridPosition(0, 0),
    var orientation: Orientation = Orientation.NORTH
) {

    fun simulate(instructions: String) {
        for (ch in instructions) {
            when (ch) {
                'R' -> orientation = turnRight(orientation)
                'L' -> orientation = turnLeft(orientation)
                'A' -> gridPosition = advance(gridPosition, orientation)
                else -> { /* ignore unknown */ }
            }
        }
    }

    private fun turnRight(o: Orientation): Orientation = when (o) {
        Orientation.NORTH -> Orientation.EAST
        Orientation.EAST  -> Orientation.SOUTH
        Orientation.SOUTH -> Orientation.WEST
        Orientation.WEST  -> Orientation.NORTH
    }

    private fun turnLeft(o: Orientation): Orientation = when (o) {
        Orientation.NORTH -> Orientation.WEST
        Orientation.WEST  -> Orientation.SOUTH
        Orientation.SOUTH -> Orientation.EAST
        Orientation.EAST  -> Orientation.NORTH
    }

    private fun advance(pos: GridPosition, o: Orientation): GridPosition = when (o) {
        Orientation.NORTH -> GridPosition(pos.x,     pos.y + 1)
        Orientation.SOUTH -> GridPosition(pos.x,     pos.y - 1)
        Orientation.EAST  -> GridPosition(pos.x + 1, pos.y)
        Orientation.WEST  -> GridPosition(pos.x - 1, pos.y)
    }
}
