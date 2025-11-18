package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    //Топливный бак
    abstract val tank: VazTank

    //Абстрактная горловина
    abstract override val tankMouth: TankMouth

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine
}

// Перечисление двигателей ВАЗ
sealed class VazEngine {
    // Объем двигателя можно задать при производстве
    abstract val volume: Int

    data class LADA_2107(override val volume: Int) : VazEngine()
    data class SAMARA_2108(override val volume: Int) : VazEngine()
}

sealed class VazTank : Tank {

    data class LADA_2107(override var fuelLevel: Int) : VazTank()
    data class LADA_2108(override var fuelLevel: Int) : VazTank()
    data class LADA_TAZ(override var fuelLevel: Int) : VazTank() {
        override fun receiveFuel(liters: Int) {
            throw IllegalStateException("Таз взорвался, господа")
        }
    }

}