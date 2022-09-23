class Bird(name: String, energy: Int, weight: Int, maxAge: Int) : Animal(name, energy, weight, maxAge) {

    override fun move() {
        super.move()
        println("Flying.")
    }

    override fun birth(): Bird {
        val born = Bird(
            name,
            energy = (1..10).random(),
            weight = (1..5).random(),
            maxAge
        )
        born.currentAge = 0
        println("The $name was born. Energy - $energy, weight - $weight, Age is $currentAge of $maxAge")
        return born
    }

}