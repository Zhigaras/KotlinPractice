abstract class AbstractWarrior : Warrior

fun AbstractWarrior.attack(victim: AbstractWarrior) {
    var damage = 0.0
    this.weapon.isLoaded = this.weapon.magazine.isNotEmpty()
    if (this.weapon.isLoaded) {
        for (item in this.weapon.toShoot()) {
            if (this.accuracy.chance() && !victim.dodgeChance.chance()) damage += item.getDamage()
        }
        victim.currentHP = maxOf(0.0, (victim.currentHP - damage))
        victim.isAlive = victim.currentHP > 0.0
    } else this.weapon.reload()
}
//Ниже функции на всякий случай

fun attack(warrior: AbstractWarrior) : MutableList<Double> {
    val damage = mutableListOf<Double>()
    warrior.weapon.isLoaded = warrior.weapon.magazine.isNotEmpty()
    if (warrior.weapon.isLoaded) {
        for (item in warrior.weapon.toShoot()) {
            if (warrior.accuracy.chance()) damage.add(item.getDamage())
        }
    } else warrior.weapon.reload()
    return damage
}

fun takeDamage(warrior: AbstractWarrior, damage: MutableList<Double>) {
    damage.forEach {
        if (warrior.dodgeChance.chance()) warrior.currentHP -= it
    }
}