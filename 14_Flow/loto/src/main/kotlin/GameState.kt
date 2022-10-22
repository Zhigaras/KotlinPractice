sealed class GameState {
    object Progress : GameState() {
        init {
            println("No winners. Continue.")
        }
    }

    class Winner(player: Player, card: Card) : GameState() {
        init {
            println("STOP GAME! We have a winner! It`s player ${player.playerID}! " +
                    "Hi`s win with card ${card.cardID}.")
        }
    }

    object GameOver : GameState() {
        init {
            println("Unfortunately we have no winner today. Looking forward next week.")
        }
    }
}
