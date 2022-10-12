import kotlin.random.Random

class Team(val name: String, warriorsAmount: Int) {

    val team = mutableListOf<AbstractWarrior>()

    init {

        for (i in 1..warriorsAmount) {
            when (true) {
                1.chance() -> team.add(General())
                2.chance() -> team.add(Captain())
                else -> team.add(Soldier())
            }
        }
    }
}

