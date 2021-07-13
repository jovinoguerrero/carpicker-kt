package com.dingodev.carpicker.vehicle.parts.seat

import com.dingodev.carpicker.vehicle.parts.Part

class Seat private constructor(
    val upholstery: Upholstery
): Part {

    override val selfPrice: Int
        get() = when(this.upholstery) {
            Upholstery.CLOTH -> 10000
            Upholstery.REXINE -> 15000
            Upholstery.LEATHER -> 20000
        }

    override val totalCost = selfPrice

    enum class Upholstery { CLOTH, REXINE, LEATHER }

    class Factory(
        val upholstery: Upholstery
    ) {
        fun createSeat(): Seat {
            return Seat(upholstery)
        }
    }
}