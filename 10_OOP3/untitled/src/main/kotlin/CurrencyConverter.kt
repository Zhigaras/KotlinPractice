interface CurrencyConverter {
    val currencyCode: String
    val currencyRate: Double
    fun convertToRub(currencyAmount: Double){
        val result = currencyAmount * currencyRate
        println("$currencyAmount $currencyCode = $result RUB.")
    }
}