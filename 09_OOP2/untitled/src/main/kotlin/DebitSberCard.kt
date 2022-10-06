class DebitSberCard(balance: Double, private val bonusValue: Double = 0.005) : DebitCard(balance) {
    private var bonusAccount: Double = 0.0
    override fun pay() {
        println("\nEnter the payment price.")
        val price = readLine()?.toDoubleOrNull()
        if (price != null) {
            if (balance < price / 2 || price > balance + bonusAccount) println("You haven`t enough money.")
            else if (price in (balance..balance + bonusAccount)) {
                val bonusToWithdraw = minOf(price / 2, bonusAccount)
                bonusAccount -= bonusToWithdraw
                balance -= (price - bonusToWithdraw)
                println("The purchasing $price USD was successful.")
            } else {
                println("Do you want to withdraw your bonus points? Y/N")
                if (readLine()?.uppercase() == "Y") {
                    balance -= price
                    if (price / 2 >= bonusAccount) {
                        balance += bonusAccount
                        bonusAccount = 0.0
                    } else {
                        balance += price / 2
                        bonusAccount -= price / 2
                    }
                } else {
                    balance -= price
                    println("The purchasing $price USD was successful.")
                    bonusAccount += price * bonusValue
                }
            }
        } else println("Wrong price amount.")
        getBalance()
    }

    override fun getBalance() {
        println("\nThe balance: ${String.format("%.2f", balance)} USD.")
        println("The bonus account: ${String.format("%.2f", bonusAccount)} USD.")
    }
}