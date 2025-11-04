package ru.otus.cars

interface TankMouth {
    val isOpened: Boolean
    fun open()
    fun close()
}

class PetrolTankMouth : TankMouth {
    override var isOpened: Boolean = false

    override fun open() {
        isOpened = true
    }

    override fun close() {
        isOpened = false
    }

    companion object : TankMouthBuilder {
        override fun build(): PetrolTankMouth = PetrolTankMouth()
    }

    override fun toString(): String {
        return "Горловина для бензина"
    }
}

class LPGTankMouth : TankMouth {
    override var isOpened: Boolean = false

    override fun open() {
        isOpened = true
    }

    override fun close() {
        isOpened = false
    }

    companion object : TankMouthBuilder {
        override fun build(): LPGTankMouth = LPGTankMouth()
    }

    override fun toString(): String {
        return "Горловина для сжиженного газа"
    }
}