package ru.otus.cars


class Tank(private val canExplode: Boolean = false) {

    var mouth: TankMouth? = null

    private var petrolVolume = 0.0
    private var gasVolume = 0.0

    fun receiveFuel(liters: Int, fuelType: FuelType) {
        val currentMouth = mouth ?: throw IllegalStateException("Mouth not set")
        if (fuelType != currentMouth.acceptedFuelType) {
            throw IllegalStateException("Fuel type mismatch: tank mouth accepts ${currentMouth.acceptedFuelType}, but got $fuelType")
        }
        currentMouth.open()
        when (fuelType) {
            FuelType.PETROL -> {
                if (canExplode) throw IllegalStateException("Tank exploded upon refueling with petrol!")
                petrolVolume += liters
            }
            FuelType.GAS -> {
                if (canExplode) throw IllegalStateException("Tank exploded upon refueling with gas!")
                gasVolume += liters
            }
        }
        currentMouth.close()
    }

    fun getContents(fuelType: FuelType): Int {
        return when (fuelType) {
            FuelType.PETROL -> petrolVolume.toInt()
            FuelType.GAS -> gasVolume.toInt()
        }
    }

    fun getFuelLevel(): Double = petrolVolume + gasVolume
}

enum class FuelType { PETROL, GAS }