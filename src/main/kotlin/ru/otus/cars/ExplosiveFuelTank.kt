package ru.otus.cars

import kotlin.random.Random

class ExplosiveFuelTank(override val maxAmount: Int) : FuelTank {
    override fun getContents(): Int {
        return Random.nextInt(0, maxAmount)
    }

    override fun receiveFuel(liters: Int) {
        throw IllegalStateException("Бак взорвался при попытке заправки.")
    }

    override fun toString(): String {
        return "Простой(нет) топливный бак на $maxAmount литров. Выглядит не надёжно"
    }

    companion object : FuelTankBuilder {
        override fun build(maxAmount: Int):  ExplosiveFuelTank{
            return ExplosiveFuelTank(maxAmount)
        }

    }
}