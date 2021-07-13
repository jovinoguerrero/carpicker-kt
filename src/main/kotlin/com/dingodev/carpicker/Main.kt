package com.dingodev.carpicker

import com.dingodev.carpicker.vehicle.Vehicle
import com.dingodev.carpicker.vehicle.parts.Chasis
import com.dingodev.carpicker.vehicle.parts.Engine
import com.dingodev.carpicker.vehicle.parts.Transmission
import com.dingodev.carpicker.vehicle.parts.WheelBase
import com.dingodev.carpicker.vehicle.parts.seat.Seat
import com.dingodev.carpicker.vehicle.parts.wheel.Wheel

class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World")

            val hondaCity = Vehicle(
                Engine(
                    Engine.Type.DIESEL,
                    Transmission(Transmission.Type.AWD)
                ),
                WheelBase(
                    WheelBase.Size.MEDIUM,
                    Chasis(
                        Chasis.Type.SEDAN,
                        Seat.Factory(Seat.Upholstery.LEATHER)
                    ),
                    Wheel.Factory(Wheel.Type.STEEL)
                ),
            )

            val ecosport = Vehicle(
                Engine(
                    Engine.Type.PETROL,
                    Transmission(Transmission.Type.FWD)
                ),
                WheelBase(
                    WheelBase.Size.SMALL,
                    Chasis(
                        Chasis.Type.SUV,
                        Seat.Factory(Seat.Upholstery.REXINE)
                    ),
                    Wheel.Factory(Wheel.Type.ALLOY)
                ),
            )

            println("HondaCity = $${hondaCity.price}")
            println("Ecosport = $${ecosport.price}")
        }
    }
}