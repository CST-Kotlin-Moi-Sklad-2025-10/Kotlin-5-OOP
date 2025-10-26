package ru.otus.cars

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
     * Топливная система - взрывающийся бак
     */
    val tankMouth: TankMouth = TankMouth.PetrolMouth
    private val tank: Tank = Tank.createExplodingTank()

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput = object : CarOutput {
        override fun getCurrentSpeed(): Int {
            throw NotImplementedError("Приборов нет")
        }

        override fun getFuelLevel(): Double {
            return tank.getFuelLevel()
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