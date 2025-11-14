package ru.otus.cars

sealed interface FuelTankMouthBuilder {
    fun build(tank: FuelTank): FuelTankMouth
}