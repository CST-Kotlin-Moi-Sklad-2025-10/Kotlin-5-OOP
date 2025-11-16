package ru.otus.cars.owner

import ru.otus.cars.animals.AnimalPartToTakeCareOf
import ru.otus.cars.animals.AnimalState
import ru.otus.cars.animals.Cat
import ru.otus.cars.animals.Crocodile
import ru.otus.cars.animals.Parrot

/**
 * Зоомагазин
 * Один из способов сделать владельца животных - человек приходит в зоомагазин и покупает животных
 * Можно выбрать конкретных животных для владельца
 * Такого владельца можно засудить, потому что он выбрал этих животных
 */
class PetShop: AnimalOwnerBuilder {
    private val animalStates = mutableListOf<AnimalState>()
    private val parts = mutableListOf<AnimalPartToTakeCareOf>()

    override fun addCat(): AnimalOwnerBuilder {
        val animal = Cat()
        animalStates.add(animal)
        parts.addAll(animal.buildParts())
        return this
    }

    override fun addParrot(): AnimalOwnerBuilder {
        val animal = Parrot()
        animalStates.add(animal)
        parts.addAll(animal.buildParts())
        return this
    }

    override fun addCrocodile(): AnimalOwnerBuilder {
        val animal = Crocodile()
        animalStates.add(animal)
        parts.addAll(animal.buildParts())
        return this
    }

    override fun build(name: String): AnimalOwner = object: AnimalOwner {
        override val name: String = name
        override val animalStateList: List<AnimalState> = animalStates
        override val tasks: List<AnimalPartToTakeCareOf> = parts

        override fun sue() {
            println("$name is sued")
        }
    }
}