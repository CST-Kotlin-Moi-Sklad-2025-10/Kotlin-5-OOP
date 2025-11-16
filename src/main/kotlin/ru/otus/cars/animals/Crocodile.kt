package ru.otus.cars.animals

/**
 * Крокодил
 * На груминге у него можно попытаться обработать
 * - Глаза
 * - Зубы
 * - Когти
 * Но он всегда кусается
 */
class Crocodile : Animal, AnimalPartsBuilder {
    override val beauty: Long = 7

    override fun increaseBeauty(amount: Long) {
        throw BiteException()
    }

    override fun buildParts(): List<AnimalPartToTakeCareOf> =
        listOf(
            Eyes(this),
            Teeth(this),
            Claws(this)
        )
}