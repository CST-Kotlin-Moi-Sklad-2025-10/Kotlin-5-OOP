package ru.otus.cars

class GasStation() {
    fun fuel(car: Car, liters: Int) {
        val mouth = car.tankMouth
        try {
            mouth.open()
            when(val tankMouth = car.tankMouth) {
                is PetrolMouth -> tankMouth.fuelPetrol(liters)
                is LPGMouth -> tankMouth.fuelLPG(liters)
                else -> IllegalArgumentException("Нет подходящего топлива на заправочной станции")
            }
            mouth.close()
        }
        catch (e: Throwable) {
            println("Что-то произошло... Фигак-фигак и всё снова хорошо")
        } finally {
            mouth.close()
        }
    }
}