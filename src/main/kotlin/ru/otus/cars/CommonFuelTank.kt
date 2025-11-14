package ru.otus.cars

class CommonFuelTank(override val maxAmount: Int) : FuelTank {
    private var currentAmount: Int = 0

    override fun getContents(): Int {
        return currentAmount
    }

    override fun receiveFuel(liters: Int) {
        val finalAmount = currentAmount + liters
        if (finalAmount > maxAmount) {
            currentAmount = maxAmount
            return
        }
        currentAmount = finalAmount
    }

    override fun toString(): String {
        return "Простой топливный бак на $maxAmount литров. СУдя по весу, внутри примерно $currentAmount литров топлива"
    }

    companion object : FuelTankBuilder {
        override fun build(maxAmount: Int): CommonFuelTank {
            return CommonFuelTank(maxAmount)
        }

    }
}