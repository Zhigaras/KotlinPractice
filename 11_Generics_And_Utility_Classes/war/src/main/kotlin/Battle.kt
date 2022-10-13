class Battle(teamSize: Int) {

    var team1 = Team("Red", teamSize)
    var team2 = Team("Blue", teamSize)
    var isOver: Boolean = false

    private fun getBattleState(): BattleState {
        return if (team1.teamList.isEmpty()) {
            isOver = true
            BattleState.Team2Win(team1)
        } else if (team2.teamList.isEmpty()) {
            isOver = true
            BattleState.Team1Win(team1)
        } else BattleState.Progress(team1, team2)
    }

    fun clutch(team1: Team, team2: Team) {
        println("\nThe \"${team1.name}\" team is attacking.")
        team1.teamList.random().attack(team2.teamList.random())
        val iterator = team2.teamList.iterator()
        while (iterator.hasNext()) {
            val it = iterator.next()
            if (!it.isAlive) {
                println("The warrior ${it.rank} was killed in \"${team2.name}\" team.")
                iterator.remove()
            }
        }
        getBattleState()
    }
}