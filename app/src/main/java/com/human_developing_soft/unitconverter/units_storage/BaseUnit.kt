package com.human_developing_soft.unitconverter.units_storage

abstract class BaseUnit {
    abstract fun convertToBase(): BaseUnit

    abstract fun value(): Float
}