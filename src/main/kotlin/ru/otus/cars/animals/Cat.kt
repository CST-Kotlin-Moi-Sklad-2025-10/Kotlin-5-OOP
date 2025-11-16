package ru.otus.cars.animals

import kotlin.random.Random

/**
 * Кошка
 * На груминге у неё можно обработать
 * - Уши
 * - Глаза
 * - Зубы
 * - Когти
 * - Длинную или короткую шерсть
 */
class Cat : Animal, AnimalPartsBuilder {
    override var beauty: Long = 100

    override fun increaseBeauty(amount: Long) {
        beauty += amount
    }

    override fun buildParts(): List<AnimalPartToTakeCareOf> =
        listOf(
            Ears(this),
            Eyes(this),
            Teeth(this),
            Claws(this),
            if (Random.nextBoolean())
                LongHair(this)
            else
                ShortHair(this)
        )
}