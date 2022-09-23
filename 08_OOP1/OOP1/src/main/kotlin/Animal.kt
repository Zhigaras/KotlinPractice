import kotlin.random.Random

open class Animal(val name: String, var energy: Int, var weight: Int, val maxAge: Int) {
    var currentAge: Int = 0
    var isTooOld: Boolean = false

    fun sleep() {
        energy += 5
        currentAge += 1
        println("$name is sleeping.")
        println("Energy is $energy, Weight is $weight, Age is $currentAge of $maxAge")
        isTooOld = currentAge > maxAge
        println("Is too old: $isTooOld")
    }

    fun eat() {
        energy += 3
        weight += 1
        tryIncrementAge(currentAge)
        println("$name is eating.")
        println("Energy is $energy, Weight is $weight, Age is $currentAge of $maxAge")
        isTooOld = currentAge > maxAge
        println("Is too old: $isTooOld")
    }

    open fun move() {
        val finalEnergy = energy - 5
        val finalWeight = weight - 1
        if (!isTooOld && (finalEnergy >= 0) && (finalWeight >= 0)) {
            energy = finalEnergy
            weight = finalWeight
            tryIncrementAge(currentAge)
            isTooOld = currentAge > maxAge
            println("$name is moving.")
            println("Energy is $energy, Weight is $weight, Age is $currentAge of $maxAge")
            println("Is too old: $isTooOld")
        }
    }

    open fun birth() : Animal {
        val born = Animal(
            name,
            energy = (1..10).random(),
            weight = (1..5).random(),
            maxAge
        )
        born.currentAge = 0
        println("The $name was born. Energy - $energy, weight - $weight, Age is $currentAge of $maxAge")
        return born
    }

    private fun tryIncrementAge(currentAge: Int): Int {
        if (Random.nextBoolean()) this.currentAge += 1
        return currentAge
    }

}