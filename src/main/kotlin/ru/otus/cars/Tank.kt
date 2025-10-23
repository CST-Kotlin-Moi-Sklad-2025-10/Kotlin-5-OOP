package ru.otus.cars

enum class TankMouthState {
    OPENED, CLOSED
}

abstract class TankMouth {
    val tank = Tank()
    private var state: TankMouthState = TankMouthState.CLOSED

    fun open() {
       this.state = TankMouthState.OPENED
    }
    fun close() {
        this.state = TankMouthState.CLOSED
    }

}

open class PetrolMouth: TankMouth() {
    private var contents: Int = 0
    open fun fuelPetrol(leters: Int): Unit {
        this.tank.receiveFuel(leters)
    }
}


class LpgMouth: TankMouth() {
    private var contents: Int = 0
    fun fuelLpg(leters: Int): Unit{
        this.tank.receiveFuel(leters)
    }
}

class Tank {
    private var contents: Int = 0

    fun getContents(): Int {
        return this.contents
    }
    fun receiveFuel(leters: Int){
        this.contents += leters
    }
}