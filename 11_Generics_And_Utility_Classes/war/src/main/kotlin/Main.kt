import kotlin.random.Random

fun main() {

    println("Enter the number of warriors in each team:")
    var teamSize: Int?
    do {
        teamSize = readLine()?.toIntOrNull()
        if (teamSize == null) println("Incorrect input. Try again.")
    } while (teamSize == null)

    val battle = Battle(teamSize)
    var iteration = 1
    do {
        println("\n============================")
        println("Iteration №${iteration}\n============================")
        clutch(battle.team1, battle.team2)
        battle.getBattleState()
        if (!battle.isOver) {
            clutch(battle.team2, battle.team1)
            battle.getBattleState()
        }
        iteration += 1
    } while (!battle.isOver)
}

fun Int.chance(): Boolean {
    return this >= Random.nextInt(1, 101)
}

