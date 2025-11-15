package ru.otus.cars

object Taz : Car {

    private val tank = Tank(canExplode = true)
    private val mouth = LpgMouth()
    override val fuelSystem: FuelSystem = FuelSystem(tank, FuelType.GAS).apply {
        tank.mouth = mouth
    }

    override val plates: Car.Plates
        get() = throw NotImplementedError("Номера сняты")

    override val color: String = "Ржавый"

    override val carOutput: CarOutput = object : CarOutput {
        override fun getCurrentSpeed(): Int = 0
        override fun getFuelContents(): Int = fuelSystem.getContents()
    }

    override fun getEquipment(): String = "Крыса"

    override fun wheelToRight(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    override fun wheelToLeft(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }
}
