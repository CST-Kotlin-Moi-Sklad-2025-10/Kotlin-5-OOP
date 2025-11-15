package ru.otus.cars

// Класс заправки с обработкой исключений при возможном взрыве бака
class GasStation {
    fun refuelCar(car: Car, liters: Int, fuelType: FuelType) {
        try {
            car.fuelSystem.refuel(liters, fuelType)
            println("${car.plates.number} refueled with $liters units of $fuelType")
        } catch (e: IllegalStateException) {
            println("Error refueling ${car.plates.number}: ${e.message}")
        }
    }

    fun refuelAll(cars: List<Car>, liters: Int, fuelType: FuelType) {
        cars.forEach { refuelCar(it, liters, fuelType) }
    }
}