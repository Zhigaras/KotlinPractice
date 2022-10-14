import PressureExceptions.*

fun main() {
    val wheel = Wheel()
    val list = listOf<Double>(-1.0, 1.0, 2.0, 5.0, 15.0)

    for (pressure in list) {
        try {
            wheel.toPumpWheel(pressure)
        } catch (_: TooHighPressure) {
            println("The pumping $pressure BAR is successful. The driving is dangerous, pressure is too high!")
        } catch (_: TooLowPressure) {
            println("The pumping $pressure BAR is successful. The driving is dangerous, pressure is too low!")
        } catch (_: IncorrectPressure) {
            println("The pumping $pressure BAR is failed. Incorrect pressure.")
        }
    }
}



