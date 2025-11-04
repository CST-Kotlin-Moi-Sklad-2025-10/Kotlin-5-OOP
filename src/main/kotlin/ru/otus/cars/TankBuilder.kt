package ru.otus.cars

sealed interface TankBuilder {
    fun build(capacity: Int, tankMouth: TankMouth): Tank
}