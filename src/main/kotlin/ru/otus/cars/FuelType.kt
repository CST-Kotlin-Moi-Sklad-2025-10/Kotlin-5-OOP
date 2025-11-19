package ru.otus.cars

enum class FuelType {
    PETROL ("БЕНЗИН"),
    LPG ("ГАЗ");

    private val fuelTypeName : String;

    constructor(fuelTypeName: String) {
        this.fuelTypeName = fuelTypeName
    }

    fun getFuelTypeName (): String {
        return fuelTypeName
    }
}