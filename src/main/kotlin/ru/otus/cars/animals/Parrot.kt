package ru.otus.cars.animals

/**
 * Попугай
 * На груминге у него можно обработать
 * - Глаза
 * - Когти
 * - Перья
 */
class Parrot: Animal, AnimalPartsBuilder {
    override var beauty: Long = 50

    override fun increaseBeauty(amount: Long) {
        beauty += amount
    }

    override fun buildParts(): List<AnimalPartToTakeCareOf> =
        listOf(
            Eyes(this),
            Claws(this),
            Feathers(this)
        )
}