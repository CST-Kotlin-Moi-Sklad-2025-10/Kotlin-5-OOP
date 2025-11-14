package ru.otus.cars

sealed interface FuelTankBuilder {
    fun build(maxAmount: Int): FuelTank
}