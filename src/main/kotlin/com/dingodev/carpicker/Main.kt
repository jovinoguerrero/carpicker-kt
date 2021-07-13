package com.dingodev.carpicker

import com.dingodev.carpicker.vehicle.Vehicle
import com.dingodev.carpicker.vehicle.parts.Chasis
import com.dingodev.carpicker.vehicle.parts.Engine
import com.dingodev.carpicker.vehicle.parts.Transmission
import com.dingodev.carpicker.vehicle.parts.WheelBase
import com.dingodev.carpicker.vehicle.parts.Seat
import com.dingodev.carpicker.vehicle.parts.Wheel
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.output.TermUi

class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("""
                | ------- Welcome to Car Picker 1.0 -------
                | Here you can build your very own car, with
                | everything fully customisable. Feel free
                | to pick engine, seats, wheels, etc.
            """.trimMargin())

            if(TermUi.confirm("Continue to build your car?") != true) {
                return
            }

            val wheelBaseSize = TermUi.prompt(
                "Enter wheelbase size: (S)mall, (M)edium or (L)arge"
            ) {
                when(it) {
                    "S", "s" -> WheelBase.Size.SMALL
                    "M", "m" -> WheelBase.Size.MEDIUM
                    "L", "l" -> WheelBase.Size.LARGE
                    else -> throw UsageError("Size has to be S, M or L")
                }
            }

            val chasisType = TermUi.prompt(
                "Enter chasis type: "
            ) {
                when(it) {
                    "S", "s" -> WheelBase.Size.SMALL
                    "M", "m" -> WheelBase.Size.MEDIUM
                    "L", "l" -> WheelBase.Size.LARGE
                    else -> throw UsageError("Size has to be S, M or L")
                }
            }

            val myCar = Vehicle(
                Engine(
                    Engine.Type.PETROL,
                    Transmission(Transmission.Type.FWD)
                ),
                WheelBase(
                    wheelBaseSize!!,
                    Chasis(
                        Chasis.Type.SUV,
                        Seat.Factory(Seat.Upholstery.REXINE)
                    ),
                    Wheel.Factory(Wheel.Type.ALLOY),
                    spareWheel = true,
                ),
            )

            println("Ecosport = $${myCar.price}")
            println("Ecosport wheels = ${myCar.wheelBase.numWheels}")
        }
    }
}