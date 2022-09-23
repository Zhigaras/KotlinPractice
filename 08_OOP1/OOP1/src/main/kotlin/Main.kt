fun main() {
    var reserve = NatureReserve().zoo
    for (i in 1..3) {
        var listToRemove = mutableListOf<Animal>()
        if (reserve.size == 0) {
            println("The Nature Reserve is empty. Program is completed.")
            return
        } else {
            println("Iteration №$i started.")
            reserve.forEach {
                when ((1..4).random()) {
                    1 -> it.move()
                    2 -> it.eat()
                    3 -> it.sleep()
                    4 -> {
                        var child = it.birth()
                        reserve = (reserve + listOf(child)).toMutableList()
                    }
                }
                if (it.isTooOld) listToRemove.add(it)
                println()
            }
            println("${listToRemove.size} animals died.")
            reserve.removeAll(listToRemove)
            println("The number of animals in National Reserve is ${reserve.size}.")

        }
        println()
    }

}