import PressureExceptions.*

class Wheel () {
    var currentPressure = 0.0

    fun toPumpWheel(pressure: Double) {
        toCheckPressure(pressure)
        currentPressure = pressure
        println("The pumping $pressure BAR is successful. Bon Voyage!")
    }

    private fun toCheckPressure(pressure: Double) {
        if (pressure < 0 || pressure > 10) throw IncorrectPressure()
        else if (pressure < 1.6) throw TooLowPressure()
        else if (pressure > 2.5) throw TooHighPressure()
    }
}
