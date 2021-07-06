package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.units_storage.PsychicUnit

interface UnitConverter {

    fun convertedUnit(
        convertingUnit: PsychicUnit,
        finallyUnitFactor: Float
    ): PsychicUnit

    class Base : UnitConverter {

        override fun convertedUnit(
            convertingUnit: PsychicUnit,
            finallyUnitFactor: Float
        ): PsychicUnit {
            val baseUnit = convertingUnit.convertToBase()
            return PsychicUnit(baseUnit, finallyUnitFactor)
        }
    }
}