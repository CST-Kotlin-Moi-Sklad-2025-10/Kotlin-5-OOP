package ru.otus.cars

/**
 * Бак для топлива
 */
interface Tank {
    /**
     * Получить текущий уровень топлива
     */
    fun getFuelLevel(): Double

    /**
     * Принять топливо
     * @param fuel - тип топлива
     * @param amount - количество литров
     */
    fun receiveFuel(fuel: Fuel, amount: Double)

    companion object {
        /**
         * Создать стандартный бак
         * @param capacity - ёмкость бака в литрах
         */
        fun createStandardTank(capacity: Double = 50.0): Tank {
            return StandardTank(capacity)
        }

        /**
         * Создать взрывающийся бак (для Таза)
         */
        fun createExplodingTank(): Tank {
            return ExplodingTank()
        }
    }
}

/**
 * Стандартный бак
 */
private class StandardTank(private val capacity: Double) : Tank {
    private var fuelLevel: Double = 0.0

    override fun getFuelLevel(): Double = fuelLevel

    override fun receiveFuel(fuel: Fuel, amount: Double) {
        // Заправляем, но не больше ёмкости бака
        val spaceLeft = capacity - fuelLevel
        val actualAmount = minOf(amount, spaceLeft)
        fuelLevel += actualAmount

        if (actualAmount < amount) {
            println("Бак полон! Залито $actualAmount л из $amount л")
        } else {
            println("Залито $actualAmount л $fuel. Уровень топлива: $fuelLevel л")
        }
    }
}

/**
 * Взрывающийся бак (для Таза)
 */
private class ExplodingTank : Tank {
    private var fuelLevel: Double = 0.0

    override fun getFuelLevel(): Double = fuelLevel

    override fun receiveFuel(fuel: Fuel, amount: Double) {
        throw IllegalStateException("БА-БАХ! Бак взорвался при попытке заправить $fuel!")
    }
}
