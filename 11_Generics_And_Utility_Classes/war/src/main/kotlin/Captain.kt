class Captain : AbstractWarrior() {
    override var maxHP: Double = 100.0
    override val accuracy = 80
    override val weapon = Weapons.createSMG()
    override var currentHP = maxHP
    override val isKilled = false
    override val dodgeChance = 50

}