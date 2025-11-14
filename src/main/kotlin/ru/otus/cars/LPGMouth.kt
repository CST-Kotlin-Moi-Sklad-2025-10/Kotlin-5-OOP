package ru.otus.cars

class LPGMouth(private val tank: FuelTank) : FuelTankMouth {
    private var isOpened: Boolean = false
    override fun open() {
        this.isOpened = true
    }

    override fun close() {
        this.isOpened = false
    }

    fun fuelLPG(liters: Int) {
        if (!isOpened) {
            throw IllegalStateException("Горловина закрыта, заправить не удалось")
        }
        if (liters < 0) {
            throw IllegalArgumentException("Данная горловина защищает от отсоса топлива. Приносим извинения за доставленные неудобства")
        }
        tank.receiveFuel(liters)
    }

    companion object : FuelTankMouthBuilder {
        override fun build(tank: FuelTank): LPGMouth {
            return LPGMouth(tank)
        }
    }
}