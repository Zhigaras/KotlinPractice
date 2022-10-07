abstract class CreditCard(balance: Double, private val creditLimit: Double = 10000.0) : BankCard(balance) {
    var ownFunds: Double = balance
    var creditFunds: Double = creditLimit

    override fun charge() {
        println("\nInsert cash into ATM or type the amount.")
        val cash = readLine()?.toIntOrNull()
        if (cash != null) {
            creditFunds += cash
            val overCharge: Double = maxOf(0.0, creditFunds - creditLimit)
            ownFunds += overCharge
            creditFunds = minOf(creditLimit, creditFunds)
            println("The charging $cash USD was successful.")
        } else println("Cash has not been inserted.")
        getAvailableFund()
    }

    override fun pay(): Boolean {
        var result = false
        println("\nEnter the payment price.")
        val price = readLine()?.toIntOrNull()
        if (price != null) {
            if (price > ownFunds+creditFunds) println("You haven`t enough money.")
            else {
                ownFunds -= price
                val overDraft: Double = minOf(0.0, ownFunds)
                creditFunds += overDraft
                ownFunds = maxOf(0.0, ownFunds)
                println("The purchasing $price USD was successful.")
                result = true
            }
        } else println("Wrong price amount.")
        getAvailableFund()
        return result
    }

    override fun getAvailableFund() {
        println("Credit funds: ${String.format("%.2f", creditFunds)} USD.")
        println("Own funds: ${String.format("%.2f", ownFunds)} USD.")
    }

}