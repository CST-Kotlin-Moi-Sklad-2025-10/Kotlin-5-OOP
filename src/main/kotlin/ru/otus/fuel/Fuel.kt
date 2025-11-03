package ru.otus.fuel


sealed class Fuel {
    abstract val liters: Int

    data class Petrol(override val liters: Int) : Fuel()

    data class LPG(override val liters: Int) : Fuel()
}