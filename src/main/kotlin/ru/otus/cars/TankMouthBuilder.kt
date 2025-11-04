package ru.otus.cars

sealed interface TankMouthBuilder {
    fun build(): TankMouth
}