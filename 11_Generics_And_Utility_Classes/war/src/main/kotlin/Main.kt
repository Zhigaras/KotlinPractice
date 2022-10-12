import kotlin.random.Random

fun main() {

    println("Enter the number of warriors in each team:")
    var warriorsAmount: Int?
    do {
        warriorsAmount = readLine()?.toIntOrNull()
        if (warriorsAmount == null) println("Incorrect input. Try again.")
    } while (warriorsAmount == null)

    val battle = Battle(warriorsAmount)
    do {
        println("\nIteration №${battle.iteration}\n")
        battle.clutch()
        battle.iteration += 1
        battle.getBattleState()

    } while (!battle.isOver)
}

fun Int.chance(): Boolean {
    return this >= Random.nextInt(1, 101)
}

