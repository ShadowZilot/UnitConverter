package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.domain.ConvertingHelperBundle
import com.human_developing_soft.unitconverter.domain.UnitList

interface UiContentHolder {

    fun formulaShells(units: UnitList): List<FormulaShell>

    fun mainObject(units: UnitList): ConvertingHelperBundle

    class Base(
        private val mChangedField: String,
        private val mPositionsList: List<Int>,
        private val mSelectedIndex: Int
    ): UiContentHolder {
        override fun formulaShells(units: UnitList): List<FormulaShell> {
            val result = mutableListOf<FormulaShell>()
            mPositionsList.forEach { index ->
                result.add(
                    units.shellByIndex(index)
                )
            }
            return result
        }

        override fun mainObject(units: UnitList): ConvertingHelperBundle {
            return ConvertingHelperBundle.Base(
                mChangedField,
                units.shellByIndex(
                    mPositionsList[mSelectedIndex]
                )
            )
        }
    }
}