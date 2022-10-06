class DebitAlfaCard(balance: Double, private val bonusValue: Double = 0.01) : DebitCard(balance) {
    private var bonusAccount: Double = 0.0

    override fun charge() {
        println("\nInsert cash into ATM or type the amount.")
        val cash = readLine()?.toIntOrNull()
        if (cash != null) {
            balance += cash
            bonusAccount += cash * bonusValue
            println("The charge was successful.")
        } else println("Cash has not been inserted.")
        getBalance()
    }

    override fun pay() {
        println("\nEnter the payment price.")
        val price = readLine()?.toDoubleOrNull()
        if (price != null) {
            if (price > balance + bonusAccount) println("You haven`t enough money.")
            else {
                bonusAccount -= price
                val overDraft: Double = minOf(0.0, bonusAccount)
                balance += overDraft
                bonusAccount = maxOf(0.0, bonusAccount)
                println("The purchasing $price USD was successful.")
            }
        } else println("Wrong price amount.")
        getBalance()
    }

    override fun getBalance() {
        println("\nThe balance: ${String.format("%.2f", balance)} USD.")
        println("The bonus account: ${String.format("%.2f", bonusAccount)} USD.")
    }
}