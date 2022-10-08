fun main() {

    val converters = object {
        private val convertersList = listOf(
            UsdConverter(),
            EurConverter(),
            CnyConverter(),
            KztConverter(),
            BynConverter(),
            HkdConverter(),
            CadConverter(),
            TryConverter(),
            JpyConverter()
        )

        fun get(currencyCode: String): CurrencyConverter {
            val filteredList = convertersList.filter { it.currencyCode == currencyCode }
            return if (filteredList.isNotEmpty()) filteredList[0]
            else object: CurrencyConverter {
                override val currencyCode = currencyCode
                override val currencyRate = 0.0
                override fun convertToRub(currencyAmount: Double) {
                    println("Sorry, we don`t know the $currencyCode currency :(")
                }

            }
        }
    }
    for (i in 1..3) {
        println("Type the currency code:")
        val currentCurrency = readLine().toString().uppercase()
        val currentConverter = converters.get(currentCurrency)
        if (currentConverter.currencyRate == 0.0) currentConverter.convertToRub(0.0)
        else {
            println("Enter the currency amount:")
            do {
                val input = readLine()?.toDoubleOrNull()
                if (input != null) currentConverter.convertToRub(input)
                else println("Wrong amount. Enter again.")
            } while (input == null)
        }
    }
}
