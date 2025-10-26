package ru.otus.cars

/**
 * Типы топлива
 */
sealed class Fuel {
    /**
     * Бензин
     */
    object Petrol : Fuel() {
        override fun toString(): String = "Бензин"
    }

    /**
     * Сжиженный газ (Liquefied Petroleum Gas)
     */
    object LPG : Fuel() {
        override fun toString(): String = "Газ"
    }
}
