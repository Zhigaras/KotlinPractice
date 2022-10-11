import kotlin.random.Random

enum class Ammo(
    private val damage: Int,
    private val criticalHitChance: Int,
    private val criticalDamageRatio: Double) {
    PISTOL(2, 10, 1.2),
    SMG(4, 30, 1.4),
    AR(8, 50, 1.8);

    private fun Int.isCritical(): Boolean {
        return this >= Random.nextInt(1,101)
    }

    fun getDamage(): Double {
        var hitDamage = damage.toDouble()
        if (criticalHitChance.isCritical()) hitDamage = damage * criticalDamageRatio
        return hitDamage
    }
}