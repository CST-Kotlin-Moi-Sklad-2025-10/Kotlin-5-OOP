package ru.otus.cars

class GasStation {

    fun fuelCar(car: Car, liters: Int) {
        val tank = car.tankMouth
        try {
            tank.open()
            when (tank) {
                is PetrolMouth -> tank.fuelPetrol(liters)
                is LpgMouth -> tank.fuelLpg(liters)
            }

        }catch (e: RuntimeException) {
            println(e.message)
        }finally {
            tank.close()
        }
    }

    fun fuelCars(cars: List<Car>, liters: Int) {
        for (car in cars) {
            println("Before: $car")
            fuelCar(car, liters)
            println("After: $car")
        }
    }
}