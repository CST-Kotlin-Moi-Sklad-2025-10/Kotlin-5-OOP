package ru.otus.cars

fun main() {
    println("\n===> drive cars...")
    driveCars()
    println("\n===> inner test...")
    innerNestedCheck()
    println("\n===> garage make...")
    garageMake()
    println("\n===> model special...")
    println("\n===> get equipment...")
    getEquipment()
    println("\n===> get color...")
    getColor()
    println("\n===> tech checks...")
    techChecks()
    println("\n===> Taz...")
    println(Taz.color)
    println("\n===> refuel testing")
    testRefueling()
    println("\n===> refuel Taz explosion")
    testRefuelTazNoPlatesException()
    println("\n===> RefuelGasCarWithPetrol")
    testRefuelGasCarWithPetrolError()
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput() // Создаем новый объект ИЗ ЭКЗЕМПЛЯРА МАШИНЫ

    println("Скорость до проверки: ${output.getCurrentSpeed()}") // Выводит 0
    Vaz2107.test(vaz) // Газуем...
    println("Скорость после проверки: ${output.getCurrentSpeed()}") // Выводит случайную скорость
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return builder.build(plates)
        }
    }

    val vaz = garage.buildCar(Vaz2107, Car.Plates("500", 50))
    println(vaz.toString())
}

fun getEquipment() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Оборудование: ${car.getEquipment()}")
    }
}

fun getColor() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Цвет: ${car.color}")
    }
}

fun techChecks() {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77))
    val vaz2 = Vaz2108.build(Car.Plates("321", 78))

    repairEngine(vaz1)
    repairEngine(vaz2)
}

fun repairEngine(car: VazPlatform) {
    // Проверяем тип двигателя
    // В зависимости от типа двигателя выполняем разные действия
    // when обеспечивает обход всех вариантов перечисления
    when (car.engine) {
        is VazEngine.LADA_2107 -> println("Чистка карбюратора у двигателя объемом ${car.engine.volume} куб.см у машины $car")
        is VazEngine.SAMARA_2108 -> println("Угол зажигания у двигателя объемом ${car.engine.volume} куб.см у машины $car")
    }
}

fun testRefueling() {
    val plates1 = Car.Plates("777AAA", 77)
    val plates2 = Car.Plates("888BBB", 78)

    val factory = Togliatti
    val vaz2107 = factory.buildCar(Vaz2107, plates1)
    val vaz2108 = factory.buildCar(Vaz2108, plates2)
    val gasStation = GasStation()

    println("Before refuel:")
    println("Vaz2107 Fuel: ${vaz2107.carOutput.getFuelContents()}")
    println("Vaz2108 Fuel: ${vaz2108.carOutput.getFuelContents()}")

    gasStation.refuelCar(vaz2107, 40, FuelType.GAS)
    gasStation.refuelCar(vaz2108, 50, FuelType.PETROL)

    println("After refuel:")
    println("Vaz2107 Fuel: ${vaz2107.carOutput.getFuelContents()}")
    println("Vaz2108 Fuel: ${vaz2108.carOutput.getFuelContents()}")
}

fun testRefuelTazNoPlatesException() {
    val taz = Taz
    val gasStation = GasStation()

    println("=== Test: refueling Taz expecting plates exception ===")

    try {
        gasStation.refuelCar(taz, 10, FuelType.GAS)
        println("ERROR: NotImplementedError exception was not thrown, test failed")
    } catch (e: NotImplementedError) {
        println("Successfully caught NotImplementedError exception: ${e.message}")
    } catch (e: Exception) {
        println("Caught unexpected exception: ${e.message}")
    }
}


fun testRefuelGasCarWithPetrolError() {
    val plates = Car.Plates("GAS001", 77)
    val factory = Togliatti
    val carOnGas = factory.buildCar(Vaz2107, plates)

    println("Tank mouth of car: ${carOnGas.fuelSystem.mouth}")
    println("FuelSystem mouth: ${carOnGas.fuelSystem.mouth}")

    val gasStation = GasStation()

    println("=== Test: attempt to fill gas car with petrol ===")

    try {
        gasStation.refuelCar(carOnGas, 20, FuelType.PETROL)
    } catch (e: IllegalStateException) {
        if (e.message == "Fuel type mismatch: expected GAS, got PETROL") {
            println("Successfully caught expected error: ${e.message}")
        } else {
            println("Caught IllegalStateException with unexpected message: ${e.message}")
        }
    } catch (e: Exception) {
        println("Caught unexpected exception: ${e.message}")
    }
}

