package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell

interface ConvertingPair {
    fun firstShell(): FormulaShell

    fun secondShell(): FormulaShell

    class Base(
        private val mFirstShell: FormulaShell,
        private val mSecondShell: FormulaShell
    ) : ConvertingPair {
        override fun firstShell(): FormulaShell {
            return mFirstShell
        }

        override fun secondShell(): FormulaShell {
            return mSecondShell
        }
    }
}