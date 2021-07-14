package com.dingodev.carpicker

import com.dingodev.carpicker.vehicle.Vehicle
import com.dingodev.carpicker.vehicle.parts.*
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

            val wheelBaseBuilder = WheelBase.Builder()
            val chasisBuilder = Chasis.Builder()
            val engineBuilder = Engine.Builder()

            // ---- start Wheelbase work ----
            TermUi.prompt(
                "Enter wheelbase size: (S)mall, (M)edium or (L)arge"
            ) {
                when(it) {
                    "S", "s" -> wheelBaseBuilder.setSize(WheelBase.Size.SMALL)
                    "M", "m" -> wheelBaseBuilder.setSize(WheelBase.Size.MEDIUM)
                    "L", "l" -> wheelBaseBuilder.setSize(WheelBase.Size.LARGE)
                    else -> throw UsageError("Size has to be S, M or L")
                }
            }!!
            wheelBaseBuilder.setWheelFactory(Wheel.Factory(Wheel.Type.ALLOY))
            // ---- end Wheelbase work ----

            // ---- start Chasis work ----
            TermUi.prompt(
                "Enter chasis type: (H)atchback, (S)edan, SU(V) or (P)ickup"
            ) {
                when(it) {
                    "H", "h" -> chasisBuilder.setChasisType(Chasis.Type.HATCHBACK)
                    "S", "s" -> chasisBuilder.setChasisType(Chasis.Type.SEDAN)
                    "V", "v" -> chasisBuilder.setChasisType(Chasis.Type.SUV)
                    "P", "p" -> chasisBuilder.setChasisType(Chasis.Type.PICKUP)
                    else -> throw UsageError("Size has to be H, S, V or P")
                }
            }!!
            // ---- end Chasis work ----

            // ---- start Engine work ----
            engineBuilder.setEngineType(Engine.Type.DIESEL)
            engineBuilder.setTransmission(Transmission(Transmission.Type.FWD))
            // ---- end Engine work ----

            chasisBuilder.setSeatFactory(Seat.Factory(Seat.Upholstery.REXINE))

            val myCar = Vehicle.Builder()
                .setChasis(chasisBuilder.build())
                .setEngine(engineBuilder.build())
                .setWheelBase(wheelBaseBuilder.build())
                .build()

            println("Ecosport = $${myCar.price}")
            println("Ecosport wheels = ${myCar.wheelBase.wheels.size}")
        }
    }
}