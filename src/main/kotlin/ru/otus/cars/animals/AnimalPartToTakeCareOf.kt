package ru.otus.cars.animals

import ru.otus.cars.animals.AnimalPartToTakeCareOf.CanClean
import ru.otus.cars.animals.AnimalPartToTakeCareOf.CanCut
import ru.otus.cars.animals.AnimalPartToTakeCareOf.CanComb

/**
 * Часть животного, которую можно попробовать обработать на груминге
 */
sealed interface AnimalPartToTakeCareOf {
    val animal: Animal

    /**
     * Интерфейс для частей животного, которые можно обрезать/постричь
     */
    sealed interface CanCut: AnimalPartToTakeCareOf {
        fun cut()
    }

    /**
     * Интерфейс для частей животного, которые можно мыть/чистить
     */
    sealed interface CanClean: AnimalPartToTakeCareOf {
        fun clean()
    }

    /**
     * Интерфейс для частей животного, которые можно расчёсывать
     */
    sealed interface CanComb: AnimalPartToTakeCareOf {
        fun comb()
    }
}

class LongHair(override val animal: Animal): CanCut, CanClean, CanComb {
    override fun cut() {
        println("cut long hair")
        animal.increaseBeauty(10)
    }

    override fun clean() {
        println("clean long hair")
        animal.increaseBeauty(15)
    }

    override fun comb() {
        println("comb long hair")
        animal.increaseBeauty(9)
    }
}

class Feathers(override val animal: Animal): CanClean {
    override fun clean() {
        println("clean feathers")
        animal.increaseBeauty(15)
    }
}

class Claws(override val animal: Animal): CanCut {
    override fun cut() {
        println("cut claws")
        animal.increaseBeauty(5)
    }
}

class ShortHair(override val animal: Animal): CanClean {
    override fun clean() {
        println("clean short hair")
        animal.increaseBeauty(13)
    }
}

class Ears(override val animal: Animal): CanClean {
    override fun clean() {
        println("clean ears")
        animal.increaseBeauty(3)
    }
}

class Eyes(override val animal: Animal): CanClean {
    override fun clean() {
        println("clean eyes")
        animal.increaseBeauty(6)
    }
}

class Teeth(override val animal: Animal): CanClean {
    override fun clean(){
        println("clean teeth")
        animal.increaseBeauty(8)
    }
}