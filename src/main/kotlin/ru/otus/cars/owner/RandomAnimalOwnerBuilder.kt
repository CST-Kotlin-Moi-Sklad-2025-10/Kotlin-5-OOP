package ru.otus.cars.owner

import kotlin.random.Random

/**
 * Генерирует рандомного владельца животных
 * Выбирает рандомный билдер владельца из представленных
 * Самая высокая вероятность у добавления кошки, самая низкая - крокодила
 *
 */
class RandomAnimalOwnerBuilder(
    private val animalOwnerBuilders: List<AnimalOwnerBuilder>
) {
    fun build() =
        animalOwnerBuilders.shuffled().first().apply {
            if(Random.Default.nextInt(0,10) > 2) addCat()
            if(Random.Default.nextInt(0,10) > 4) addParrot()
            if(Random.Default.nextInt(0,10) > 9) addCrocodile()
        }.build(generateRandomName())

    private fun generateRandomName(): String =
        generateRandomLatinChar().uppercase() +
                (0..7).joinToString("") { generateRandomLatinChar().toString() }.lowercase()

    private fun generateRandomLatinChar() =
        (Random.Default.nextInt(0, 20) + 'A'.code).toChar()

}