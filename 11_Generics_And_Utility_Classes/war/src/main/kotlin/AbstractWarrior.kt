import kotlin.random.Random

abstract class AbstractWarrior : Warrior {

    override fun attack(attacker: AbstractWarrior, victim: AbstractWarrior) {
        var damage = 0.0
        if (attacker.weapon.isLoaded) {
            for (item in attacker.weapon.toShoot()) {
                if (attacker.accuracy.chance() && !victim.dodgeChance.chance()) damage += item.getDamage()
            }
            victim.currentHP -= damage
        } else weapon.reload()
    }

    /*Альтернативный вариант


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
}*/

}
