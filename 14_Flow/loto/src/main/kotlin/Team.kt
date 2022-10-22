import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.cancel

class Team(numberOfPlayers: Int, numberOfCards: Int) {
    val playersList = mutableListOf<Player>()
    val jobList = mutableListOf<Job>()

    init {
        for (i in 1..numberOfPlayers) {
            playersList.add(Player(numberOfCards, i))
            jobList.add(Job())
        }
    }

    fun printTeamCards() {
        playersList.forEach { player ->
            player.cardsList.forEach { card ->
                println("Player ${player.playerID}, card ${card.cardID}")
                card.printCardNumbers()
            }
        }
    }

    fun getGameState() {
        playersList.forEach { player ->
            player.cardsList.forEach { card ->
                card.card.forEach { row ->
                    if (row.all { number: Number -> number.isMarkered }) {
                        player.isWinner = true
                        //return GameState.Winner(player, card)
                    }
                }
            }
        }
        //return GameState.Progress
    }
}
