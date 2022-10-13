abstract class AbstractWarrior : Warrior

fun AbstractWarrior.attack (victim: AbstractWarrior) {
    var damage = 0.0
    this.weapon.isLoaded = this.weapon.magazine.isNotEmpty()
    if (this.weapon.isLoaded) {
        for (item in this.weapon.toShoot()) {
            if (this.accuracy.chance() && !victim.dodgeChance.chance()) damage += item.getDamage()
        }
        victim.currentHP = maxOf(0.0, (victim.currentHP - damage))
        victim.isAlive = victim.currentHP > 0.0
    } else weapon.reload()
}