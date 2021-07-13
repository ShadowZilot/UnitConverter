package com.human_developing_soft.unitconverter.units_storage

import com.human_developing_soft.unitconverter.converting_logic.PsychicUnit

abstract class BaseUnit {
    abstract fun convertToBase(): BaseUnit

    abstract fun value(): Double

    class Dummy(
        private val mValue: Double
    ) : BaseUnit() {

        constructor() : this(0.0)

        override fun convertToBase(): BaseUnit {
            return PsychicUnit(mValue)
        }

        override fun value(): Double {
            return mValue
        }
    }
}