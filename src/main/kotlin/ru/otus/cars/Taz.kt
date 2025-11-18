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

    val tank : Tank = VazTank.LADA_TAZ(32);
    override val tankMouth: TankMouth = getRandomTankMouth()

    fun getRandomTankMouth(): TankMouth {
        return when (Random.nextInt(0, 1)) {
            0 -> TankMouth.PetrolMouth(tank)
            else -> TankMouth.LPGMouth(tank)
        }
    }

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

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
}