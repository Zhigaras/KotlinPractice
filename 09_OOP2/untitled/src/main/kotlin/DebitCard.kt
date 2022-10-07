abstract class DebitCard(balance: Double) : BankCard(balance) {

    override fun charge() {
        println("\nInsert cash into ATM or type the amount.")
        val cash = readLine()?.toIntOrNull()
        if (cash != null) {
            balance += cash
            println("The charge was successful.")
        } else println("Cash has not been inserted.")
        getBalance()
    }

    override fun pay(): Boolean {
        var result = false
        println("\nEnter the payment price.")
        val price = readLine()?.toIntOrNull()
        if (price != null) {
            if (price > balance) println("You haven`t enough money.")
            else {
                balance -= price
                println("The purchasing $price USD was successful.")
                result = true
            }
        } else println("Wrong price amount.")
        getBalance()
        return result
    }

    override fun getBalance() {
        println("The balance: $balance USD.")
    }

}