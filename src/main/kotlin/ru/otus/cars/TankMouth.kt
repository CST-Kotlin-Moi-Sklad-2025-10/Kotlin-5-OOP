package ru.otus.cars

/**
 * Горловина бака
 */
sealed interface TankMouth {
    /**
     * Тип топлива, который принимает горловина
     */
    val acceptedFuel: Fuel

    /**
     * Бензиновая горловина
     */
    object PetrolMouth : TankMouth {
        override val acceptedFuel: Fuel = Fuel.Petrol
        override fun toString(): String = "Бензиновая горловина"
    }

    /**
     * Газовая горловина (для сжиженного газа)
     */
    object LPGMouth : TankMouth {
        override val acceptedFuel: Fuel = Fuel.LPG
        override fun toString(): String = "Газовая горловина"
    }
}
