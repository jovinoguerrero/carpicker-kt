package com.dingodev.carpicker.vehicle.parts

class WheelBase private constructor(
    val size: Size,
    val chasis: Chasis,
    val wheels: List<Wheel>,
): Part {

    override val selfPrice: Int
        get() = when(this.size) {
            Size.SMALL -> 100000
            Size.MEDIUM -> 125000
            Size.LARGE -> 175000
        }
    override val totalCost: Int
        get() = selfPrice + chasis.totalCost + wheels.sumBy { it.totalCost }

    enum class Size { SMALL, MEDIUM, LARGE }

    class Builder {

        private lateinit var size: Size
        private lateinit var chasis: Chasis
        private lateinit var wheelFactory: Wheel.Factory
        private var spareWheel: Boolean = false


        fun setSize(size: Size): Builder {
            this.size = size
            return this
        }

        fun setChasis(chasis: Chasis): Builder {
            this.chasis = chasis
            return this
        }

        fun setWheelFactory(wheelFactory: Wheel.Factory): Builder {
            this.wheelFactory = wheelFactory
            return this
        }

        fun setSpareWheel(spareWheel: Boolean): Builder {
            this.spareWheel = spareWheel
            return this
        }

        fun build(): WheelBase {
            return WheelBase(
                this.size,
                this.chasis,
                this.wheelFactory.createWheels(
                    4 + if(this.spareWheel) 1 else 0
                ),
            )
        }
    }
}