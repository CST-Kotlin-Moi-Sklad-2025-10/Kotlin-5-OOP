package ru.otus.cars

import ru.otus.fuel.Fuel

class FuelSystem<in T : Fuel>(mouthFactory: (Tank) -> TankMouth<T>, val fuelType: String, volume: Int ) {
    private val tank = Tank(volume)
    val tankMouth = mouthFactory(tank)

    val max = tank.volume


    fun getFuelLevel(): Int {
        return tank.fuelLevel
    }

    companion object {

        inline fun <reified T : Fuel> create(noinline mouthFactory: (Tank) -> TankMouth<T>, volume: Int): FuelSystem<T> {
            return FuelSystem(mouthFactory, T::class.simpleName ?: "Unknown", volume)
        }
        val LPGFuelSystem = create<Fuel.LPG>(TankMouth.LPG::create, 60)
        val PetrolFuelSystem = create< Fuel.Petrol>(TankMouth.Petrol::create, 40)
    }
}