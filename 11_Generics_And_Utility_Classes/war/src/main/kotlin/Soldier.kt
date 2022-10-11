class Soldier : AbstractWarrior() {
    override var maxHP: Double = 50.0
    override val accuracy = 60
    override val weapon = Weapons.createPistol()
    override var currentHP = maxHP
    override val isKilled = false
    override val dodgeChance = 30

}