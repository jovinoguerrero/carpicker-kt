package com.dingodev.carpicker.vehicle.parts

class Engine (
    val type: Type,
    val transmission: Transmission
): Part {

    override val price: Int
        get() = when(this.type) {
            Type.PETROL -> 100000
            Type.DIESEL -> 200000
            Type.HYBRID -> 500000
            Type.ELECTRIC -> 400000
        }

    enum class Type { PETROL, DIESEL, HYBRID, ELECTRIC }
}