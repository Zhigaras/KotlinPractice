import kotlin.math.round

sealed class BattleState {

    class Progress(team1: Team, team2: Team) : BattleState() {
        init {
            println("${team1.teamList.filter { it.isAlive }.size} warrior(s) in ${team1.name} team." +
                    "\nOverall HP = ${String.format("%.1f", team1.getOverallHP())}.")
            println("${team2.teamList.filter { it.isAlive }.size} warrior(s) in ${team2.name} team." +
                    "\nOverall HP = ${String.format("%.1f", team2.getOverallHP())}.")
        }
    }

    class Team1Win(team1: Team) : BattleState() {
        init {
            println("Congratulations! The \"${team1.name}\" team won!")
        }
    }

    class Team2Win(team2: Team) : BattleState() {
        init {
            println("Congratulations! The \"${team2.name}\" team won!")
        }
    }


}
