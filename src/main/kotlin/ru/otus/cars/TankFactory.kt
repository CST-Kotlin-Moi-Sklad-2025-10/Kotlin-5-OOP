package ru.otus.cars

interface TankFactory {
    fun buildTank(builder: TankBuilder, tankMouth: TankMouth): Tank
}

object TankMainFactory : TankFactory {
    private fun buildGeneralTank(tankMouth: TankMouth): Tank {
        println("Выпуск обычного бака...")
        val tank = GeneralTank.build(
            capacity = 100,
            tankMouth = tankMouth
        )
        return tank
    }

    override fun buildTank(builder: TankBuilder, tankMouth: TankMouth): Tank {
        return when (builder) {
            is GeneralTank.Companion -> return buildGeneralTank(tankMouth)
        }
    }
}