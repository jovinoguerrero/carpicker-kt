package com.dingodev.carpicker.vehicle.parts

class WheelBase (
    val size: Size,
    val chasis: Chasis
): Part {

    val wheels: List<Wheel> = listOf(
        Wheel(), Wheel(), Wheel(), Wheel()
    )
    override val price: Int
        get() = when(this.size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.BIG -> 175000
        }

    enum class Size { SMALL, MEDIUM, BIG }
}