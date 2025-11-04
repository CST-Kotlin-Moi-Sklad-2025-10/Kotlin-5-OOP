package ru.otus.cars

interface TankMouthFactory {
    fun buildTankMouth(builder: TankMouthBuilder): TankMouth
}

object TankMouthMainFactory : TankMouthFactory {
    private fun buildPetrolTankMouth(): TankMouth {
        println("Выпуск горловины для бензина...")
        val mouth = PetrolTankMouth.build()
        return mouth
    }

    private fun buildLPGTankMouth(): TankMouth {
        println("Выпуск горловины для сжиженного газа...")
        val mouth = LPGTankMouth.build()
        return mouth
    }

    override fun buildTankMouth(builder: TankMouthBuilder): TankMouth {
        return when (builder) {
            is PetrolTankMouth.Companion -> return buildPetrolTankMouth()
            is LPGTankMouth.Companion -> return buildLPGTankMouth()
        }
    }
}