abstract class BankCard(var balance: Double) {
    abstract fun charge()
    abstract fun pay(): Boolean
    open fun getBalance() {}
    open fun getAvailableFund() {}
}