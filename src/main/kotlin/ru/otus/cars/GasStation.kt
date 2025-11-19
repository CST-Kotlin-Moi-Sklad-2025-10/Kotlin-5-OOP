package ru.otus.cars

object GasStation {

    fun refuelCar(car: Car) {
        println("_____________________________________")
        println("Начинаем заправку этого авто -> $car")

        try {
            when (car.tankMouth) {
                is TankMouth.PetrolMouth -> {
                    println("У автомобиля обнаружена БЕНЗИНОВАЯ горловина")
                    val howMuchFuel = (5..35).random()
                    println("Собираемся заправить $howMuchFuel литров БЕНЗИНА")
                    car.tankMouth.addFuelToTank(howMuchFuel)
                    println("Успешно заправились БЕНЗИНЧИКОМ. В добрый путь!")
                }
                is TankMouth.LPGMouth -> {
                    println("У автомобиля обнаружена ГАЗОВАЯ горловина")
                    val howMuchFuel = (5..35).random()
                    println("Собираемся заправить $howMuchFuel литров ГАЗА")
                    car.tankMouth.addFuelToTank(howMuchFuel)
                    println("Успешно заправились ГАЗИКОМ. В добрый путь!")
                }
            }
        } catch (e : IllegalStateException) {
            println(">>> Внезапный взрыв ТАЗа! <<<")
            println("Ё моё, ничего себе")
            println("Еще один таз не выдержал суровой жизни")
            println("Ровных дорог тебе на том свете, братишка")
        }
    }
}