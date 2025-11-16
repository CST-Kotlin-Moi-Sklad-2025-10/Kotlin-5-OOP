package ru.otus.cars.owner

import ru.otus.cars.animals.AnimalPartToTakeCareOf
import ru.otus.cars.animals.AnimalState

/**
 * Владелец животных
 * У него есть:
 * - Имя
 * - Список состояний его животных (одно животное - одно состояние)
 * - Список частей его животных, которые он пришёл обработать на груминге
 * Владельца животного можно попытаться засудить
 */
interface AnimalOwner {
    val name: String
    val animalStateList: List<AnimalState>
    val tasks: List<AnimalPartToTakeCareOf>
    fun sue()
}