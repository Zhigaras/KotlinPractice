import kotlin.random.Random

class Team(warriorsAmount: Int?) {

    companion object {

        fun createTeam(warriorsAmount: Int): MutableList<AbstractWarrior> {
            val team = mutableListOf<AbstractWarrior>()
            for (i in 1..warriorsAmount) {
                when (Random.nextInt(1, 101)) {
                    in (1..2) -> team.add(General())
                    in (3..4) -> team.add(Captain())
                    else -> team.add(Soldier())
                }
            }
            return team
        }
    }
}
