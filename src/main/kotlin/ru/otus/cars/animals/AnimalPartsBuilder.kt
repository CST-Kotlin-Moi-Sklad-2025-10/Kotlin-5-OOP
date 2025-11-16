package ru.otus.cars.animals

/**
 * Интерфейс для создания списка частей животного,
 * которые можно попробоать обработать на груминге
 */
interface AnimalPartsBuilder {
    fun buildParts(): List<AnimalPartToTakeCareOf>
}