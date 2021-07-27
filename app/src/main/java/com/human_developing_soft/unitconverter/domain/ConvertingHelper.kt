package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.PsychicUnit
import com.human_developing_soft.unitconverter.converting_logic.UnitConverter

interface ConvertingHelper {
    fun convertedValue(argument: Double,
                       firstFlag: Boolean): Double

    class Base(
        private val mConvertingPair: ConvertingPair
    ) : ConvertingHelper {
        override fun convertedValue(argument: Double,
                                    firstFlag: Boolean): Double {
            if (firstFlag) {
                return UnitConverter.Base(
                    PsychicUnit(
                        argument,
                        mConvertingPair.secondShell().formulaCurrent(),
                        mConvertingPair.secondShell().formulaBase()
                    ),
                    mConvertingPair.firstShell().formulaCurrent()
                ).convertedResult().value()
            } else {
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
}