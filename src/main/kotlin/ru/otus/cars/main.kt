package ru.otus.cars

import ru.otus.cars.owner.PetShop
import ru.otus.cars.owner.RandomAnimalOwnerBuilder
import ru.otus.cars.owner.Street
import ru.otus.cars.salons.MyGroomingSalon

fun main() {
    val salon = MyGroomingSalon()
    val owners = (0..10).map {
        val ownersBuilder = RandomAnimalOwnerBuilder(listOf(PetShop(), Street()))
        ownersBuilder.build()
    }
    owners.forEach {
        salon.handleClient(it)
    }
    owners.forEach {
        println("${it.name} ${it.animalStateList.joinToString(","){ it.beauty.toString() }}")
    }
}