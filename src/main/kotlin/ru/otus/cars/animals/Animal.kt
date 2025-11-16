package ru.otus.cars.animals

/**
 * Животное
 * У кажого животного можно попытаться увеличить красоту,
 * но они могут кусаться при попытке это сделать
 */
interface Animal: AnimalState {
    @Throws(BiteException::class)
    fun increaseBeauty(amount: Long)
}