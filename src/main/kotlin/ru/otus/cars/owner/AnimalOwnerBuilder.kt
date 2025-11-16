package ru.otus.cars.owner

/**
 * Интейрфейс для создания владельца животных
 * Можно добавить владельцу кошку, попугая и крокодила
 * При создании владельца обязательно нужно указать его имя
 */
interface AnimalOwnerBuilder {
    fun addCat(): AnimalOwnerBuilder
    fun addParrot(): AnimalOwnerBuilder
    fun addCrocodile(): AnimalOwnerBuilder
    fun build(name: String): AnimalOwner
}