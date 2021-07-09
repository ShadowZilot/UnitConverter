package com.human_developing_soft.unitconverter.converting_logic.converting_formula

import com.human_developing_soft.unitconverter.units_storage.BaseUnit

interface ConvertingObject {
    fun baseUnit(): BaseUnit

    fun currentUnit(): BaseUnit

    class Base(
        private val mValue: Float,
        private val mFormulaTo: StringFormula,
        private val mFormulaFrom: StringFormula
    ) : ConvertingObject {

        override fun baseUnit(): BaseUnit {
            return mFormulaTo.calculableFormula(mValue).result()
        }

        override fun currentUnit(): BaseUnit {
            return mFormulaFrom.calculableFormula(mValue).result()
        }
    }
}