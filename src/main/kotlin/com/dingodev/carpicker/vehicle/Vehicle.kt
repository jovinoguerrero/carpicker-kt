package com.dingodev.carpicker.vehicle

import com.dingodev.carpicker.vehicle.parts.Engine
import com.dingodev.carpicker.vehicle.parts.WheelBase

class Vehicle(
    val engine: Engine,
    val wheelBase: WheelBase
) {
    val price = wheelBase.totalCost + engine.totalCost
}