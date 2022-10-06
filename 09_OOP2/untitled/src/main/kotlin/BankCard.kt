abstract class BankCard(var balance: Double) {
    abstract fun charge()
    abstract fun pay()
    open fun getBalance() {}
    open fun getAvailableFund() {}
}