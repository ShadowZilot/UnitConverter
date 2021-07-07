package com.human_developing_soft.unitconverter.converting_logic

interface UnitConverter {

    fun convertedUnit(
            convertingUnit: PsychicUnit,
            finallyUnitFactor: ConvertingFactor
    ): PsychicUnit

    class Base : UnitConverter {

        override fun convertedUnit(
                convertingUnit: PsychicUnit,
                finallyUnitFactor: ConvertingFactor
        ): PsychicUnit {
            val baseUnit = convertingUnit.convertToBase()
            return PsychicUnit(baseUnit, finallyUnitFactor)
        }
    }
}