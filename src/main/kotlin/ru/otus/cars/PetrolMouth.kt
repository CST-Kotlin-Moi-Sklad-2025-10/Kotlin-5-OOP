package ru.otus.cars

class PetrolMouth(private val tank: FuelTank) : FuelTankMouth {
    private var isOpened: Boolean = false
    override fun open() {
        this.isOpened = true
    }

    override fun close() {
        this.isOpened = false
    }

    fun fuelPetrol(liters: Int) {
        if (!isOpened) {
            throw IllegalStateException("Горловина закрыта, заправить не удалось")
        }
        tank.receiveFuel(liters)
    }

    companion object : FuelTankMouthBuilder {
        override fun build(tank: FuelTank): PetrolMouth {
            return PetrolMouth(tank)
        }
    }
}