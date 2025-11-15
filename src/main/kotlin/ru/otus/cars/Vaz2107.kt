package ru.otus.cars

import kotlin.random.Random

/**
 * Семёрочка
 */
class Vaz2107 private constructor(color: String) : VazPlatform(color) {
    companion object : CarBuilder {
        private fun getRandomEngine(): VazEngine {
            return when (Random.nextInt(0, 2)) {
                0 -> VazEngine.LADA_2107(1300)
                else -> VazEngine.LADA_2107(1600)
            }
        }

        override fun build(plates: Car.Plates): Vaz2107 = Vaz2107("Зеленый").apply {
            this.engine = getRandomEngine()
            this.plates = plates
            this.fuelSystem = createFuelSystem()
        }

        private fun createFuelSystem(): FuelSystem {
            val tank = Tank(canExplode = false)
            val mouth = LpgMouth()
            tank.mouth = mouth
            return FuelSystem(tank, FuelType.GAS)
        }

        fun test(vaz2107: Vaz2107) {
            println("Проверяем, едет ли ВАЗ 2107...")
            vaz2107.currentSpeed = Random.nextInt(0, 60)
        }

        const val MODEL = "2107"
    }

    override lateinit var engine: VazEngine
        private set

    fun drdrdrdrdr() {
        println("Помчали на $MODEL:")
        println("Др-др-др-др....")
    }

    private var currentSpeed: Int = 0

    override lateinit var plates: Car.Plates
        private set

    override lateinit var fuelSystem: FuelSystem

    override fun toString(): String {
        return "Vaz2107(plates=$plates, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed)"
    }

    override val carOutput: CarOutput = VazOutput()

    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }

        override fun getFuelContents(): Int {
            return this@Vaz2107.fuelSystem.getContents()
        }
    }
}