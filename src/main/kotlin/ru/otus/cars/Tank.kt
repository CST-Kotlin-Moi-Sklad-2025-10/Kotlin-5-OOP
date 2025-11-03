package ru.otus.cars

class Tank(val volume: Int): Fillable {
    var fuelLevel: Int = 0

    override  fun add(liters: Int) {
        fuelLevel += liters
    }

}