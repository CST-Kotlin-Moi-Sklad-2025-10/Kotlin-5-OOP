package ru.otus.cars.salons

import ru.otus.cars.owner.AnimalOwner

/**
 * Салон груминга
 * Здесь можно обслужить владельца животных
 */
interface GroomingSalon {
    fun handleClient(animalOwner: AnimalOwner)
}