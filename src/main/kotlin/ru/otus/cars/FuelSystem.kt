package ru.otus.cars

class FuelSystem(private val tank: Tank, private val fuelType: FuelType) {

    val mouth: TankMouth? get() = tank.mouth

    fun refuel(liters: Int, fuelType: FuelType) {
        mouth?.receiveFuel(tank, liters, fuelType) ?: throw IllegalStateException("Tank mouth not set")
    }

    fun getFuelLevel(): Double = tank.getFuelLevel()

    fun getContents(): Int = tank.getContents(fuelType)
}