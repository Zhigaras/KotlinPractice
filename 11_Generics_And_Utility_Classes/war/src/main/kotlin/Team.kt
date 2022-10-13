class Team(val name: String, teamSize: Int) {

    val teamList = mutableListOf<AbstractWarrior>()

    init {
        for (i in 1..teamSize) {
            when (true) {
                10.chance() -> teamList.add(General())
                30.chance() -> teamList.add(Captain())
                else -> teamList.add(Soldier())
            }
        }
        printTeamInfo()
    }

    fun printTeamInfo() {
        println("\nThe \"$name\" team:")
        teamList.forEachIndexed { i, it ->
            println("${String.format("%2d", i+1)}. ${String.format("%10s", it.rank)} " +
                    "${String.format("%6.1f", it.currentHP)} HP.") }
        println("-------------------------")
        println("${String.format("%14s", "Overall")} ${String.format("%6.1f", getOverallHP())} HP.")
    }

    private fun getOverallHP(): Double {
        var overallHP = 0.0
        teamList.forEach { overallHP += it.currentHP }
        return overallHP
    }
}

