class Team(name: String, warriorsAmount: Int) {
    val name = name

    val teamList = mutableListOf<AbstractWarrior>()
    init {
        for (i in 1..warriorsAmount) {
            when (true) {
                10.chance() -> teamList.add(General())
                30.chance() -> teamList.add(Captain())
                else -> teamList.add(Soldier())
            }
        }
        println("\nThe $name team:")
        teamList.forEach { println("${it.rank} - ${it.currentHP} HP.")  }
        //println(getOverallHP())
    }

    fun getOverallHP() : Double {
        var overallHP = 0.0
        teamList.forEach{overallHP += it.currentHP}
        return overallHP
    }
}

