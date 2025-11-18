package ru.otus.cars

interface TankMouth {

    val allowedFuelType: FuelType

    val tank: Tank

    fun open() {
        println("Открываем горловину бака с типом $allowedFuelType")
    }

    fun close() {
        println("Закрываем горловину бака с типом $allowedFuelType")
    }

    fun addFuelToTank(liters: Int) {
        tank.receiveFuel(liters)
    }

    class PetrolMouth(override val tank: Tank) : TankMouth {
        override val allowedFuelType = FuelType.PETROL;

        fun fuelPetrol(liters: Int) {
            addFuelToTank(liters)
        }
    }

    class LPGMouth(override val tank: Tank) : TankMouth {
        override val allowedFuelType = FuelType.LPG;

        fun fuelLpg(liters: Int) {
            addFuelToTank(liters)
        }
    }
}