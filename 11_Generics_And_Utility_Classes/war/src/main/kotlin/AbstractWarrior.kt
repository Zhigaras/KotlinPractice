import kotlin.random.Random

abstract class AbstractWarrior : Warrior {

    fun clutch(attacker: AbstractWarrior, enemy: AbstractWarrior) {
        var damage = attacker.attack()
        enemy.takeDamage(damage)
    }

    override fun attack(): MutableList<Double> {
        var firedBullets = mutableListOf<Double>()
        if (weapon.isLoaded) {
        for (item in weapon.toShoot()) {
            if (accuracy.hitHappened()) firedBullets.add(item.getDamage())
            }
        }
        else weapon.reload()
        return firedBullets
    }

    override fun takeDamage(firedBullets: MutableList<Double>) {
        for (item in firedBullets){
            if (!dodgeChance.hitHappened()) currentHP -= item
        }
}

    private fun Int.hitHappened(): Boolean {
        return this >= Random.nextInt(1, 101)
    }
}
