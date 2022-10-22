import kotlinx.coroutines.*

fun main() {

    val numberOfPlayers = inputRequest(10, "players")
    val numberOfCards = inputRequest(5, "cards")
    val team = Team(numberOfPlayers, numberOfCards)

    team.printTeamCards()

    runBlocking {
        println("The game started.")
        var counter = 0
        Generator.sharedFlow.collect { generatedNumber ->
            counter++
            println("$counter number - $generatedNumber")
            team.playersList.forEachIndexed { playerIndex, player ->
                team.jobList[playerIndex] = launch {
                    player.checkNumber(generatedNumber)
                    team.jobList.forEach { yield() }
                    if (player.isWinner) {
                        println("Player ${player.playerID} won!")
                        team.jobList.forEach { cancel() }
                    }
                }
            }
        }
    }
    team.printTeamCards()



    /*runBlocking {
        var counter = 1
        Generator.sharedFlow.collect { generatedNumber ->
            yield()
            println("number - $generatedNumber")
            team.playersList.forEachIndexed { playerIndex, player ->
                team.jobList[playerIndex] = launch {
                    counter++
                    player.checkNumber(generatedNumber)
                    yield()
                    if (player.isWinner) team.jobList.forEach { cancel() }
                }
            }
        }
        team.jobList.joinAll()
        team.printTeamCards()
    }*/


    /*runBlocking {
        println("The game started.")
        var counter = 0
        while (currentCoroutineContext().isActive) {
            Generator.sharedFlow.collect { generatedNumber ->
                counter++
                println("$counter number - $generatedNumber")
                team.playersList.forEachIndexed { index, player ->
                    val job = launch {
                        player.checkNumber(generatedNumber)
                        delay(100)
                        team.getGameState()
                    }
                    if (player.isWinner)
                        job.cancel()
                }
            }
        }
        team.printTeamCards()
    }*/

}

fun inputRequest(maxNumber: Int, requestItem: String): Int {
    println("Enter the number of $requestItem ($maxNumber max!).")
    var requestResult: Int?
    do {
        requestResult = readLine()?.toIntOrNull()
        if (requestResult == null) println("Incorrect input. Try again.")
        else if (requestResult > maxNumber || requestResult == 0) println("Input is out of bounds.")
    } while (requestResult == null || requestResult > maxNumber || requestResult == 0)
    return requestResult
}