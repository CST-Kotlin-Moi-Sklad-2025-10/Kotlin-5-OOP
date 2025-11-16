package ru.otus.cars.salons

import ru.otus.cars.animals.AnimalPartToTakeCareOf
import ru.otus.cars.animals.BiteException
import ru.otus.cars.owner.AnimalOwner

/**
 * Конкретный салон груминга
 * Пытается выполнить все возможные процедуры для частей тела животных,
 * которые хочет обработать владелец
 * Если хотя бы одно животное кусается в процессе груминга,
 * салон не обрабатывает части тела оставшихся животных и пытается засудить владельца
 */
class MyGroomingSalon: GroomingSalon {
    override fun handleClient(animalOwner: AnimalOwner) {
        try{
            animalOwner.tasks.forEach {
                when(it){
                    is AnimalPartToTakeCareOf.CanClean -> it.clean()
                    is AnimalPartToTakeCareOf.CanCut -> it.cut()
                    is AnimalPartToTakeCareOf.CanComb -> it.comb()
                }
            }
        } catch (_: BiteException){
            animalOwner.sue()
        }
    }
}