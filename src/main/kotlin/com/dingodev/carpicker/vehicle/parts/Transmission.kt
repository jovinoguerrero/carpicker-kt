package com.dingodev.carpicker.vehicle.parts

class Transmission (
    val type: Type
): Part {
    override val price: Int
        get() = when(this.type) {
            Type.RWD -> 90000
            Type.FWD -> 75000
            Type.AWD -> 110000
        }

    enum class Type { RWD, FWD, AWD }
}