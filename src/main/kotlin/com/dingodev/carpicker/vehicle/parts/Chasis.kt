package com.dingodev.carpicker.vehicle.parts

class Chasis (val type: Type): Part {
    val seats: List<Seat> = listOf(
        Seat(), Seat(), Seat(), Seat()
    )
    override val price: Int
        get() = when(this.type) {
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 200000
            Type.SUV -> 250000
            Type.PICKUP -> 350000
        }

    enum class Type { HATCHBACK, SEDAN, SUV, PICKUP }
}