package ru.otus.cars

interface Tank {
    /**
     * Горловина бензобака
     */
    val tankMouth: TankMouth

    /**
     * Получить текущий запас топлива
     */
    fun getCurrentFuelLevel(): Int

    /**
     * Принять топливо
     */
    fun receiveFuel(liters: Int)
}