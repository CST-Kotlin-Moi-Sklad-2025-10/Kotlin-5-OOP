package ru.otus.cars

import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor(color: String) : VazPlatform(color) {
    companion object : CarBuilder {
        private fun getRandomEngine(): VazEngine {
            return when (Random.nextInt(0, 3)) {
                0 -> VazEngine.SAMARA_2108(1100)
                1 -> VazEngine.SAMARA_2108(1300)
                else -> VazEngine.SAMARA_2108(1500)
            }
        }

        override fun build(plates: Car.Plates): Vaz2108 = Vaz2108("Красный").apply {
            this.engine = getRandomEngine()
            this.plates = plates
            this.fuelSystem = createFuelSystem()
        }

        private fun createFuelSystem(): FuelSystem {
            val tank = Tank(canExplode = false)
            val mouth = PetrolMouth()
            tank.mouth = mouth
            return FuelSystem(tank, FuelType.PETROL)
        }

        fun alignWheels(vaz2108: Vaz2108) {
            println("Ваз 2108 выравнивает колёса... ")
            vaz2108.wheelAngle = 0
        }

        const val MODEL = "2108"
    }

    override lateinit var engine: VazEngine
        private set

    fun zhzhzhzh() {
        println("Помчали на $MODEL:")
        println("Ж-ж-ж-ж....")
    }

    override fun getEquipment(): String {
        return super.getEquipment() + ", музыка"
    }

    private var currentSpeed: Int = 0

    override lateinit var fuelSystem: FuelSystem

    override lateinit var plates: Car.Plates
        private set

    override fun toString(): String {
        return "Vaz2108(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed)"
    }

    override val carOutput: CarOutput = VazOutput()

    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2108.fuelSystem.getContents()
        }
    }
}
