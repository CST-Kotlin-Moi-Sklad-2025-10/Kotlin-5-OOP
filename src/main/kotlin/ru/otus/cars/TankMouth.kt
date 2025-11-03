package ru.otus.cars

import ru.otus.fuel.Fuel

interface Fillable {
    fun add(liters: Int)
}

sealed class TankMouth<in T : Fuel>(private  val tank: Fillable) {
    private var isOpen = false

    open fun fill(fuel: T) {
        if (!isOpen){
            throw Error("Гороловина не была открыта. Разлив топлива!")
        }
        tank.add(fuel.liters)
    }

    fun open(){
        isOpen = true
    }

    fun close(){
        isOpen = false
    }

     open class LPG(tank: Fillable): TankMouth<Fuel.LPG>(tank) {
         companion object {
             fun create(tank: Fillable): LPG {
                 return LPG(tank)
             }
         }
     }
     class Petrol(tank: Fillable): TankMouth<Fuel.Petrol>(tank){
         companion object {
             fun create(tank: Fillable): Petrol {
                 return Petrol(tank)
             }
         }
     }

}


