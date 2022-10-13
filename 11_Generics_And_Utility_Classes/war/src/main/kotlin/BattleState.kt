sealed class BattleState {

    class Progress(team1: Team, team2: Team) : BattleState() {
        init {
            team1.printInfo()
            team2.printInfo()
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
