import kotlin.random.Random

fun main() {

    println("Enter the number of warriors in each team:")
    var warriorsAmount: Int?
    do {
        warriorsAmount = readLine()?.toIntOrNull()
        if (warriorsAmount == null) println("Incorrect input. Try again.")
    } while (warriorsAmount == null)

    var redTeam = Team.createTeam(warriorsAmount)
    var blueTeam = Team.createTeam(1)

    /*val sold1 = Soldier()
    val sold2 = Soldier()

    val cap1 = Captain()
    val cap2 = Captain()

    val gen1 = General()
    val gen2 = General()

    println("${sold1.hashCode()}, ${sold2.hashCode()}")
    println(cap1 == cap2)
    println(gen1 == gen2)*/

    for (warrior in redTeam) warrior.clutch(warrior, blueTeam[0])


}

fun Int.chance(): Boolean {
    return this >= Random.nextInt(1, 101)
}