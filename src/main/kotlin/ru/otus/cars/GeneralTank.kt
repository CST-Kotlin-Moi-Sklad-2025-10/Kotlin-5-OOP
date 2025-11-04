package ru.otus.cars

class GeneralTank(private val capacity: Int, override val tankMouth: TankMouth) : Tank {
    companion object : TankBuilder {
        override fun build(capacity: Int, tankMouth: TankMouth): GeneralTank = GeneralTank(capacity, tankMouth)
    }

    // Текущий уровень топлива, л
    private var currentFuelLevel: Int = 0

    override fun getCurrentFuelLevel(): Int = currentFuelLevel

    // Выводим состояние бака
    override fun toString(): String {
        return "Обычный бак (заполнен на $currentFuelLevel из $capacity л), $tankMouth"
    }

    override fun receiveFuel(liters: Int) {
        if (!tankMouth.isOpened) {
            println("Крышка бака закрыта! Разлилось $liters л")
            return
        }

        val remainingCapacity = capacity - currentFuelLevel
        currentFuelLevel += liters

        if (currentFuelLevel > capacity) {
            val overflow = currentFuelLevel - capacity
            println("Бак переполнен! Заполнили $remainingCapacity л, разлилось $overflow л")
            currentFuelLevel = capacity
        } else {
            println("Заполнили $liters л")
        }
    }
}