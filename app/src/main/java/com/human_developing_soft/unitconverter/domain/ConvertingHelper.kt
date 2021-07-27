package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.PsychicUnit
import com.human_developing_soft.unitconverter.converting_logic.UnitConverter

interface ConvertingHelper {
    fun convertedValue(argument: Double): Double

    class Base(
        private val mConvertingPair: ConvertingPair
    ) : ConvertingHelper {
        override fun convertedValue(argument: Double): Double {
            return UnitConverter.Base(
                PsychicUnit(
                    argument,
                    mConvertingPair.firstShell().formulaCurrent(),
                    mConvertingPair.firstShell().formulaBase()
                ),
                mConvertingPair.secondShell().formulaCurrent()
            ).convertedResult().value()
        }
    }
}