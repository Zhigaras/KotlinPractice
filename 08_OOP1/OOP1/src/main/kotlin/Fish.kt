class Fish(name: String, energy: Int, weight: Int, maxAge: Int) : Animal(name, energy, weight, maxAge) {

    override fun move() {
        super.move()
        println("Swimming.")
    }

    override fun birth(): Fish {
        val born = Fish(
            name,
            energy = (1..10).random(),
            weight = (1..5).random(),
            maxAge
        )
        born.currentAge = 0
        println("The $name was born. Energy - $energy, weight - $weight, Max Age - $maxAge.")
        return born
    }
}