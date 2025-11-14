package ru.otus.cars

interface FuelTank {
    val maxAmount: Int
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}