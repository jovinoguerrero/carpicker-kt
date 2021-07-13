package com.dingodev.carpicker.vehicle.parts

class Engine: Part {
    val transmission: Transmission = Transmission()

    override val price: Int
        get() = 150000
}