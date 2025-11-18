package ru.otus.cars

interface Tank {

    var fuelLevel : Int

    fun getContents(): Int {
        return fuelLevel
    }

    fun receiveFuel(liters:Int) {
        fuelLevel += liters
    }

}