open class PressureExceptions(message: String) : Throwable(message) {
    class TooHighPressure : PressureExceptions (message = "The pressure is too high!")
    class TooLowPressure : PressureExceptions (message = "The pressure is too low!")
    class IncorrectPressure : PressureExceptions (message = "The pressure is incorrect!")
}