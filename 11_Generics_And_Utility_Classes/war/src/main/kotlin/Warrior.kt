interface Warrior {
    val maxHP: Double
    val isKilled: Boolean
    val dodgeChance: Int
    val accuracy: Int
    val weapon: Weapon
    var currentHP: Double

    fun attack (): MutableList<Double>
    fun takeDamage (firedBullets: MutableList<Double>)
}