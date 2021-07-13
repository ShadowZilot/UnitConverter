package com.human_developing_soft.unitconverter.converting_logic

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.StringFormula
import com.human_developing_soft.unitconverter.units_storage.BaseUnit

interface UnitConverter {

    fun convertedResult(): BaseUnit

    class Base(
        private val mConvertingUnit: BaseUnit,
        private val mFormulaFrom: StringFormula
    ) : UnitConverter {

        override fun convertedResult(): BaseUnit {
            return PsychicUnit(
                mConvertingUnit.convertToBase(),
                mFormulaFrom
            )
        }
    }
}