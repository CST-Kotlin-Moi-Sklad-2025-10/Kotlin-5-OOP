package ru.otus.cars.fuel_system

sealed class Tank {
    abstract fun receiveFuel(litres: Int, fuelType: FuelType)

    class Normal : Tank() {
        private var petrolLevel: Int = 0
        private var lpgLevel: Int = 0

        override fun receiveFuel(litres: Int, fuelType: FuelType) {
            when (fuelType) {
                FuelType.PETROL -> petrolLevel += litres
                FuelType.LPG -> lpgLevel += litres
            }
        }

        fun getPetrolLevel(): Int = petrolLevel
        fun getLpgLevel(): Int = lpgLevel
        fun getTotalContents(): Int = petrolLevel + lpgLevel
    }

    class Exploding : Tank() {
        override fun receiveFuel(litres: Int, fuelType: FuelType) {
            throw TankExplosionException("БАК ВЗОРВАЛСЯ! Taz нельзя заправлять!")
        }

        fun getPetrolLevel(): Int = 0
        fun getLpgLevel(): Int = 0
        fun getTotalContents(): Int = 0
    }
}

class TankExplosionException(message: String) : Exception(message)