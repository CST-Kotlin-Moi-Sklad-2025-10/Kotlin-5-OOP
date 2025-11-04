package ru.otus.cars

import kotlin.random.Random

object Taz: Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw NotImplementedError("Номера сняты")

    /**
     * Цвет машины
     */
    override val color: String = "Ржавый"

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw NotImplementedError("Приборов нет")

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String {
        if (isOperational) {
            return listOf("Крыса", tank.toString())
                .joinToString(", ")
        } else {
            return "Машина неисправна"
        }
    }

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw NotImplementedError("Руля нет")
    }

    private var isOperational: Boolean = true

    override var tank: Tank = run {
        val delegate = GeneralTank(
            capacity = 0,
            tankMouth = getRandomTankMouth().build()
        )

        object : Tank by delegate {
            override fun receiveFuel(liters: Int) {
                isOperational = false
                throw IllegalStateException("БА-БАХ! Хорошая попытка, но бак взорвался")
            }

            override fun toString(): String = delegate.toString()
        }
    }

    override val tankMouth: TankMouth
        get() = tank.tankMouth

    private fun getRandomTankMouth(): TankMouthBuilder {
        return when (Random.nextInt(0, 2)) {
            0 -> PetrolTankMouth
            else -> LPGTankMouth
        }
    }
}