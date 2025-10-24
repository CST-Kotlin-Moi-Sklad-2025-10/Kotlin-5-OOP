package ru.otus.cars.fuel_system

class FuelCar private constructor(
    val name: String,
    val plates: String,
    val tankMouth: TankMouth,
    val tank: Tank
) {
    companion object {
        fun createVaz2107(plates: String): FuelCar {
            return FuelCar(
                name = "VAZ-2107",
                plates = plates,
                tankMouth = LpgTankMouth,
                tank = Tank.Normal()
            )
        }

        fun createVaz2108(plates: String): FuelCar {
            return FuelCar(
                name = "VAZ-2108",
                plates = plates,
                tankMouth = PetrolTankMouth,
                tank = Tank.Normal()
            )
        }

        fun createTaz(plates: String): FuelCar {
            return FuelCar(
                name = "TAZ",
                plates = plates,
                tankMouth = PetrolTankMouth,
                tank = Tank.Exploding()
            )
        }
    }

    fun refuel(liters: Int) {
        println("Заправка $name ($plates):")
        tankMouth.open()
        try {
            tankMouth.fuel(liters, tank)
        } catch (e: TankExplosionException) {
            println("!!! КРИТИЧЕСКАЯ ОШИБКА: ${e.message} !!!")
        } finally {
            tankMouth.close()
        }

        val totalFuel = when (tank) {
            is Tank.Normal -> tank.getTotalContents()
            is Tank.Exploding -> 0
        }
        println("Уровень топлива: $totalFuel л\n")
    }

    override fun toString(): String {
        val (totalFuel, petrol, lpg) = when (tank) {
            is Tank.Normal -> Triple(
                tank.getTotalContents(),
                tank.getPetrolLevel(),
                tank.getLpgLevel()
            )
            is Tank.Exploding -> Triple(0, 0, 0)
        }

        val fuelType = when {
            petrol > 0 -> "бензин"
            lpg > 0 -> "газ"
            else -> "пусто"
        }

        return "🚗 $name [$plates] | Топливо: $totalFuel л ($fuelType) | " +
                "Бензин: $petrol л | Газ: $lpg л"
    }
}