object Weapons {

    fun createPistol(): Weapon {
        val anonymous = object : Weapon(
            fireType = FireType.SingleShot,
            maxBullets = 10,
            magazine = Stack(),
            isLoaded = false
        ) {
            //override val isLoaded = magazine.isNotEmpty()

            override fun createAmmo(): Ammo {
                return Ammo.PISTOL
            }
        }
        return anonymous
    }

    fun createSMG(): Weapon {
        val anonymous = object : Weapon(
            fireType = FireType.BurstShot(3),
            maxBullets = 20,
            magazine = Stack(),
            isLoaded = false
        ) {
            //override val isLoaded = magazine.isNotEmpty()

            override fun createAmmo(): Ammo {
                return Ammo.SMG
            }
        }
        return anonymous
    }

    fun createAR(): Weapon {
        val anonymous = object : Weapon(
            fireType = FireType.BurstShot(5),
            maxBullets = 30,
            magazine = Stack(),
            isLoaded = false
        ) {
            //override val isLoaded = magazine.isNotEmpty()

            override fun createAmmo(): Ammo {
                return Ammo.AR
            }
        }
        return anonymous
    }
}