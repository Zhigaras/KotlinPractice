import kotlin.random.Random

fun main() {

    println("Enter the number of warriors in each team:")
    var warriorsAmount: Int?
    do {
        warriorsAmount = readLine()?.toIntOrNull()
        if (warriorsAmount == null) println("Incorrect input. Try again.")
    } while (warriorsAmount == null)

    var redTeam = Team("Red",warriorsAmount).team
    var blueTeam = Team("Blue",1).team




    for (warrior in redTeam) warrior.attack(warrior, blueTeam[0])
}

fun Int.chance(): Boolean {
    return this >= Random.nextInt(1, 101)
}