class SpaceAge(private val seconds: Int) {

    private val earthYearSeconds = 31_557_600.0

    private fun age(orbitalPeriodInEarthYears: Double): Double =
        seconds.toDouble() / (earthYearSeconds * orbitalPeriodInEarthYears)

    fun onEarth(): Double    = age(1.0)
    fun onMercury(): Double  = age(0.2408467)
    fun onVenus(): Double    = age(0.61519726)
    fun onMars(): Double     = age(1.8808158)
    fun onJupiter(): Double  = age(11.862615)
    fun onSaturn(): Double   = age(29.447498)
    fun onUranus(): Double   = age(84.016846)
    fun onNeptune(): Double  = age(164.79132)
}
