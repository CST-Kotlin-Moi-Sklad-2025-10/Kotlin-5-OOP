package ru.otus.cars


sealed interface TankMouth {
    val acceptedFuelType: FuelType

    fun open()
    fun close()

    fun receiveFuel(tank: Tank, liters: Int, fuelType: FuelType) {
        if (fuelType != acceptedFuelType) {
            throw IllegalStateException("Fuel type mismatch: mouth accepts $acceptedFuelType, attempted to fill $fuelType")
        }
        tank.receiveFuel(liters, fuelType)
    }
}

class PetrolMouth : TankMouth {
    override val acceptedFuelType = FuelType.PETROL

    override fun receiveFuel(tank: Tank, liters: Int, fuelType: FuelType) {
        if (fuelType != acceptedFuelType) {
            throw IllegalStateException("Fuel type mismatch: expected $acceptedFuelType, got $fuelType")
        }
        tank.receiveFuel(liters, fuelType)
    }

    override fun open() {
        println("Petrol mouth opened")
    }

    override fun close() {
        println("Petrol mouth closed")
    }
}

class LpgMouth : TankMouth {
    override val acceptedFuelType = FuelType.GAS

    override fun receiveFuel(tank: Tank, liters: Int, fuelType: FuelType) {
        if (fuelType != acceptedFuelType) {
            throw IllegalStateException("Fuel type mismatch: expected $acceptedFuelType, got $fuelType")
        }
        tank.receiveFuel(liters, fuelType)
    }

    override fun open() {
        println("LPG mouth opened")
    }

    override fun close() {
        println("LPG mouth closed")
    }
}
