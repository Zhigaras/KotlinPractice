class NatureReserve {
    var zoo = mutableListOf<Animal>()
    var dog = Dog("dog", (1..10).random(),(1..5).random(),3)
    var bird = Bird("bird", (1..10).random(),(1..5).random(),3)
    var fish = Fish("fish", (1..10).random(),(1..5).random(),3)
    var animal = Animal("animal", (1..10).random(),(1..5).random(),3)
    init {
        for (i in 1..5) zoo.add(bird)
        for (i in 1..3) zoo.add(fish)
        for (i in 1..2) zoo.add(dog)
        for (i in 1..(1..5).random()) zoo.add(animal)
    }
}