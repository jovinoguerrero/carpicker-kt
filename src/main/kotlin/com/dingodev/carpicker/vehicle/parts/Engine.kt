package com.dingodev.carpicker.vehicle.parts

class Engine private  constructor(
    val type: Type,
    val transmission: Transmission
): Part {

    override val selfPrice: Int
        get() = when(this.type) {
            Type.PETROL -> 100000
            Type.DIESEL -> 200000
            Type.HYBRID -> 500000
            Type.ELECTRIC -> 400000
        }
    override val totalCost: Int
        get() = selfPrice + transmission.totalCost

    enum class Type { PETROL, DIESEL, HYBRID, ELECTRIC }

    class Builder {

        lateinit var engineType: Engine.Type
        lateinit var transmission: Transmission

        fun setEngineType(engineType: Engine.Type): Builder {
            this.engineType = engineType
            return this
        }

        fun setTransmission(transmission: Transmission): Builder {
            this.transmission = transmission
            return this
        }

        fun build(): Engine {
            return Engine(this.engineType, this.transmission)
        }
    }
}