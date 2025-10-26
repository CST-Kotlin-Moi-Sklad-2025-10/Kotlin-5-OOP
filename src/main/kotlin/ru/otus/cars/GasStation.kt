package ru.otus.cars

/**
 * Заправочная станция
 */
object GasStation {
    /**
     * Заправить машину
     */
    fun refuel(car: Car) {
        println("\n=== Заправка машины ===")

        try {
            // Определяем тип горловины и заправляем соответствующим топливом
            when (car) {
                is VazPlatform -> {
                    when (car.tankMouth) {
                        is TankMouth.PetrolMouth -> {
                            println("Обнаружена бензиновая горловина")
                            refuelWithPetrol(car)
                        }
                        is TankMouth.LPGMouth -> {
                            println("Обнаружена газовая горловина")
                            refuelWithLPG(car)
                        }
                    }
                }
                is Taz -> {
                    // Таз - особый случай
                    println("Обнаружена бензиновая горловина")
                    refuelWithPetrol(Taz)
                }
                else -> {
                    println("Неизвестный тип машины!")
                }
            }
        } catch (e: IllegalStateException) {
            // Обрабатываем взрыв бака
            println("⚠️ ВНИМАНИЕ! Авария при заправке!")
            println("⚠️ ${e.message}")
            println("⚠️ Заправка прекращена из соображений безопасности!")
        } catch (e: Exception) {
            println("⚠️ Ошибка при заправке: ${e.message}")
        }
    }

    /**
     * Заправить бензином
     */
    private fun refuelWithPetrol(car: VazPlatform) {
        println("Заправка бензином...")
        car.refuel(Fuel.Petrol, 40.0)
    }

    /**
     * Заправить бензином (для Таза)
     */
    private fun refuelWithPetrol(taz: Taz) {
        println("Заправка бензином...")
        // У Таза нельзя напрямую получить tank, поэтому используем рефлексию
        val tankField = Taz::class.java.getDeclaredField("tank")
        tankField.isAccessible = true
        val tank = tankField.get(Taz) as Tank
        tank.receiveFuel(Fuel.Petrol, 40.0)
    }

    /**
     * Заправить газом
     */
    private fun refuelWithLPG(car: VazPlatform) {
        println("Заправка газом...")
        car.refuel(Fuel.LPG, 40.0)
    }
}
