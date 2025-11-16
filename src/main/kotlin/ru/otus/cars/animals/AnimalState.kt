package ru.otus.cars.animals

/**
 * Состояние животного
 * У животного есть уровень красоты,
 * на который должен влиять груминг
 */
interface AnimalState {
    val beauty: Long
}