package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell

interface ConvertingHelperBundle {

    fun value(): Double

    fun shells(): FormulaShell

    class Base(
        private val mValue: String,
        private val mFormula: FormulaShell
    ): ConvertingHelperBundle {
        override fun value(): Double {
            if (mValue.isNotEmpty()) {
                return mValue.toDouble()
            } else {
                throw NumberFormatException("Empty field input!")
            }
        }

        override fun shells(): FormulaShell {
            return mFormula
        }
    }
}