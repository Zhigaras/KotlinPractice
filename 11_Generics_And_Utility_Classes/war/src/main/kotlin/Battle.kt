class Battle(warriorsAmount: Int) {

    var team1 = Team("Red", warriorsAmount)
    var team2 = Team("Blue", warriorsAmount)
    var isOver: Boolean = false
    var iteration = 1

    private fun getBattleState(): BattleState {
        return if (team1.teamList.isEmpty()) {
            isOver = true
            BattleState.Team2Win(team1)
        } else if (team2.teamList.isEmpty()) {
            isOver = true
            BattleState.Team1Win(team1)
        } else BattleState.Progress(team1, team2)
    }

    fun clutch() {
        println("\nThe \"${team1.name}\" team is attacking.")
        team1.teamList.random().attack(team2.teamList.random())
        var iterator = team2.teamList.iterator()
        while (iterator.hasNext()) {
            val it = iterator.next()
            if (!it.isAlive) {
                println("The warrior ${it.rank} was killed in ${team2.name} team.")
                iterator.remove()
            }
        }
        getBattleState()

        println("\nThe \"${team1.name}\" team is attacking.")
        team2.teamList.random().attack(team1.teamList.random())
        iterator = team1.teamList.iterator()
        while (iterator.hasNext()) {
            val it = iterator.next()
            if (!it.isAlive) {
                println("The warrior ${it.rank} was killed in ${team1.name} team.")
                iterator.remove()
            }
        }
        getBattleState()
    }

    /*Вариант с итераторами (не очень рабочий)
    fun clutch() {
        val iter1 = team1.teamList.iterator()
        val iter2 = team2.teamList.iterator()
        do {
            val iterWarrior1 = iter1.next()
            val iterWarrior2 = iter2.next()
            if (iterWarrior1.isAlive)
                iterWarrior1.attack(team2.teamList.random())
            team2.teamList.removeIf { !it.isAlive }
            getBattleState()

            if (iterWarrior2.isAlive)
                iterWarrior2.attack(team1.teamList.random())
            team1.teamList.removeIf { !it.isAlive }
            getBattleState()

        }while (iter1.hasNext())
    }*/

}


