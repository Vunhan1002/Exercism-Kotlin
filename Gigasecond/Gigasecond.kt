import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond {

    val date: LocalDateTime

    constructor(start: LocalDate) {
        date = start.atStartOfDay().plusSeconds(1_000_000_000L)
    }

    constructor(start: LocalDateTime) {
        date = start.plusSeconds(1_000_000_000L)
    }
}
