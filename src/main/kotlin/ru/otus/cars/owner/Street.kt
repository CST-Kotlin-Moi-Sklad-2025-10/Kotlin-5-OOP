package ru.otus.cars.owner

import ru.otus.cars.animals.AnimalPartToTakeCareOf
import ru.otus.cars.animals.Animal
import ru.otus.cars.animals.AnimalState
import ru.otus.cars.animals.Cat
import ru.otus.cars.animals.Crocodile
import ru.otus.cars.animals.Parrot
import kotlin.random.Random

/**
 * Улица
 * Один из способов сделать владельца животных - человек подбирает животных на улице
 * Владелец всегда получает не то животное, которое хотел бы взять
 * Такого владельца нельзя засудить, потому что он не выбирал этих животных
 */
class Street : AnimalOwnerBuilder {
    private val animals = mutableListOf<Animal>()
    private val parts = mutableListOf<AnimalPartToTakeCareOf>()

    override fun addCat(): AnimalOwnerBuilder {
        val animal = if (Random.nextBoolean())
            Parrot()
        else
            Crocodile()
        animals.add(animal)
        parts.addAll(animal.buildParts())
        return this
    }

    override fun addParrot(): AnimalOwnerBuilder {
        val animal = if (Random.nextBoolean())
            Cat()
        else
            Crocodile()
        animals.add(animal)
        parts.addAll(animal.buildParts())
        return this
    }

    override fun addCrocodile(): AnimalOwnerBuilder {
        val animal = if (Random.nextBoolean())
            Parrot()
        else
            Cat()
        animals.add(animal)
        parts.addAll(animal.buildParts())
        return this
    }

    override fun build(name: String): AnimalOwner = object : AnimalOwner {
        override val name: String = name
        override val animalStateList: List<AnimalState> = animals
        override val tasks: List<AnimalPartToTakeCareOf> = parts

        override fun sue() {
            println("You can't sue me, this is not my animal")
        }
    }
}