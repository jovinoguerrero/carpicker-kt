package com.dingodev.carpicker.vehicle.parts

class Chasis private constructor(
    val type: Type,
    val seats: List<Seat>
): Part {
    override val selfPrice: Int
        get() = when(this.type) {
            Type.HATCHBACK -> 150000
            Type.SEDAN -> 200000
            Type.SUV -> 250000
            Type.PICKUP -> 350000
        }

    override val totalCost: Int
        get() = selfPrice + seats.sumBy { it.totalCost }

    enum class Type { HATCHBACK, SEDAN, SUV, PICKUP }

    class Builder {

        lateinit var chasisType: Chasis.Type
        lateinit var seatFactory: Seat.Factory

        fun setChasisType(chasisType: Type): Builder {
            this.chasisType = chasisType
            return this
        }

        fun setSeatFactory(seatFactory: Seat.Factory): Builder {
            this.seatFactory = seatFactory
            return this
        }

        fun build(): Chasis {
            val numSeats = when(this.chasisType) {
                Type.HATCHBACK -> 4
                Type.SEDAN -> 5
                Type.SUV -> 8
                Type.PICKUP -> 6
            }
            return Chasis(
                this.chasisType,
                this.seatFactory.createSeats(numSeats)
            )
        }
    }
}