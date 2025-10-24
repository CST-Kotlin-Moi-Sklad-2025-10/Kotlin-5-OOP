package ru.otus.cars.fuel_system

fun demoFuelSystem() {
    println("\n" + "=".repeat(60))
    println("🚦 ДЕМОНСТРАЦИЯ ТОПЛИВНОЙ СИСТЕМЫ")
    println("=".repeat(60))

    val cars = listOf(
        FuelCar.createVaz2107("A111AA"),
        FuelCar.createVaz2108("B222BB"),
        FuelCar.createTaz("C333CC")
    )

    println("\n📊 СОСТОЯНИЕ БАКОВ ДО ЗАПРАВКИ:")
    println("-".repeat(60))
    cars.forEach { println(it) }

    GasStation.refuelAll(cars, liters = 40)

    println("📊 СОСТОЯНИЕ БАКОВ ПОСЛЕ ЗАПРАВКИ:")
    println("-".repeat(60))
    cars.forEach { println(it) }

    println("\n🔧 ИНДИВИДУАЛЬНАЯ ЗАПРАВКА TAZ:")
    println("-".repeat(40))
    val extraTaz = FuelCar.createTaz("F666FF")
    println("До заправки: $extraTaz")
    GasStation.refuelCar(extraTaz, 30)
    println("После заправки: $extraTaz")
}