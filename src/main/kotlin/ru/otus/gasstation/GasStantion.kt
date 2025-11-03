package ru.otus.gasstation

import ru.otus.cars.Car
import ru.otus.cars.TankMouth
import ru.otus.fuel.Fuel
import kotlin.random.Random

class GasStantion {

    fun fuelCar(car: Car, liters: Int) {
        val tankMouth = car.tankMouth
        try {
            tankMouth.open()
            println("Заправляем $liters литров в $car")
            when (tankMouth) {
                is TankMouth.LPG -> tankMouth.fill(Fuel.LPG(liters))
                is TankMouth.Petrol -> tankMouth.fill(Fuel.Petrol(liters))
            }
        }catch (e: Throwable) {
            println(e.message)
        }finally {
            car.tankMouth.close()
        }
    }

    fun fuelCars(cars: List<Car>) {
        for (car in cars) {
            println("До заправки: $car")

            val liters = try {
                car.tankMax - car.carOutput.getFuelLevel()
            } catch (t: Throwable){
                car.tankMax
            }

            fuelCar(car, Random(1).nextInt(liters))
            println("После заправки: $car")
        }
    }
}