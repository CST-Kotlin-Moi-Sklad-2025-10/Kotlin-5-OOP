package ru.otus.cars

import kotlin.random.Random

object GasStation {

    fun refuelCar(car: Car, liters: Int) {
        println("Состояние машины перед заправкой: ${car.getEquipment()}")

        val tankMouth = car.tankMouth
        try {
            if (Random.nextBoolean()) {
                tankMouth.open()
            }
            when (tankMouth) {
                is PetrolTankMouth -> println("Заправляем $liters л бензина...")
                is LPGTankMouth -> println("Заправляем $liters л газа...")
            }
            car.tank.receiveFuel(liters)
        } catch (e: Exception) {
            println("Произошла авария: ${e.message}. Вызываем бригаду на помощь...")
        } finally {
            car.tankMouth.close()
        }

        println("Состояние машины после заправки: ${car.getEquipment()}")
    }

    fun refuelCars(cars: List<Car>) {
        for (car in cars) {
            refuelCar(car, Random.nextInt(50, 150))
        }
    }
}