package ru.otus.cars.fuel_system

sealed interface TankMouth {
    fun open()
    fun close()
    fun fuel(liters: Int, tank: Tank)
}

object PetrolTankMouth : TankMouth {
    override fun open() = println("Бензиновая горловина открыта")
    override fun close() = println("Бензиновая горловина закрыта")
    override fun fuel(liters: Int, tank: Tank) {
        tank.receiveFuel(liters, FuelType.PETROL)
        println("Заправлено $liters литров бензина")
    }
}

object LpgTankMouth : TankMouth {
    override fun open() = println("Газовая горловина открыта")
    override fun close() = println("Газовая горловина закрыта")
    override fun fuel(liters: Int, tank: Tank) {
        tank.receiveFuel(liters, FuelType.LPG)
        println("Заправлено $liters литров газа")
    }
}