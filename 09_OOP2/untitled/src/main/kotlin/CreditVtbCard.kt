class CreditVtbCard(balance: Double, private val bonusValue: Double) : CreditCard(balance) {
    private var bonusAccount: Double = 0.0

    override fun pay() {
        println("\nEnter the payment price.")
        val price = readLine()?.toIntOrNull()
        if (price != null) {
            if (price > ownFunds + creditFunds + bonusAccount) println("You haven`t enough money.")
            else {
                println("Do you want to withdraw your bonus points? Y/N")
                if (readLine()?.uppercase() == "Y") {
                    bonusAccount -= price
                    var overDraft: Double = minOf(0.0, bonusAccount)
                    ownFunds += overDraft
                    overDraft = minOf(0.0, ownFunds)
                    creditFunds += overDraft
                    bonusAccount = maxOf(0.0, bonusAccount)
                    ownFunds = maxOf(0.0, ownFunds)
                    println("The purchasing $price USD was successful.")
                } else {
                    ownFunds -= price
                    val overDraft: Double = minOf(0.0, ownFunds)
                    creditFunds += overDraft
                    ownFunds = maxOf(0.0, ownFunds)
                    if (price >= 5000.0) bonusAccount += bonusValue * price
                    println("The purchasing $price USD was successful.")
                }
            }
        } else println("Wrong price amount.")
        getAvailableFund()
    }

    override fun getAvailableFund() {
        super.getAvailableFund()
        println("The bonus account: ${String.format("%.2f", bonusAccount)} USD.")
    }
}