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
        println("\n============================")
        println("Iteration №${battle.iteration}\n============================")
        clutch(battle.team1, battle.team2)
        battle.getBattleState()
        if (!battle.isOver) {
            clutch(battle.team2, battle.team1)
            battle.getBattleState()
            battle.iteration += 1
        }
    } while (!battle.isOver)
}

fun Int.chance(): Boolean {
    return this >= Random.nextInt(1, 101)
}

