package ru.otus.cars.fuel_system

object GasStation {
    fun refuelCar(car: FuelCar, liters: Int = 50) {
        println("⚡ Заправка автомобиля ${car.name} (${car.plates})")
        try {
            car.refuel(liters)
            println("✅ Успешно заправлено $liters литров\n")
        } catch (e: TankExplosionException) {
            println("💥 На заправке произошла авария: ${e.message}\n")
        }
    }

    fun refuelAll(cars: List<FuelCar>, liters: Int = 50) {
        println("=== НАЧАЛО ЗАПРАВКИ КОЛЛЕКЦИИ МАШИН ===")
        cars.forEach { refuelCar(it, liters) }
        println("=== ЗАВЕРШЕНИЕ ЗАПРАВКИ ===\n")
    }
}