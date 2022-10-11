class General : AbstractWarrior() {
    override var maxHP: Double = 200.0
    override val accuracy = 95
    override val weapon = Weapons.createAR()
    override var currentHP = maxHP
    override val isKilled = false
    override val dodgeChance = 70

}