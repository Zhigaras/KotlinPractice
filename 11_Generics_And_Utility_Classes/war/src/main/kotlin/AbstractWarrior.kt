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
            if (accuracy.chance()) firedBullets.add(item.getDamage())
            }
        }
        else weapon.reload()
        return firedBullets
    }

    override fun takeDamage(firedBullets: MutableList<Double>) {
        for (item in firedBullets){
            if (!dodgeChance.chance()) currentHP -= item
        }
}

}
