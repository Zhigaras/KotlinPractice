
abstract class Weapon(
    val maxBullets: Int,
    val fireType: FireType,
    val magazine: Stack<Ammo>,
    var isLoaded: Boolean
) {
    init {
        reload()
    }

    abstract fun createAmmo(): Ammo

    fun reload() {
        magazine.clear()
        for (i in 1..maxBullets) magazine.push(createAmmo())
        isLoaded = magazine.isNotEmpty()
    }

    fun toShoot(): MutableList<Ammo> {
        var firedBullets = mutableListOf<Ammo>()
        val amountOfBullets: Int = when (fireType) {
            is FireType.SingleShot -> 1
            is FireType.BurstShot -> fireType.burstSize
        }
        for (i in 1..amountOfBullets) {
            magazine.pop()?.let { firedBullets.add(it) }
        }
        return firedBullets
    }
}
