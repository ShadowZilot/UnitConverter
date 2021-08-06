package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.domain.ConvertingHelperBundle
import com.human_developing_soft.unitconverter.domain.MediumContent
import com.human_developing_soft.unitconverter.domain.UnitList

interface UiContentHolder {

    fun formulaShells(units: UnitList): List<FormulaShell>

    fun mainObject(units: UnitList): ConvertingHelperBundle

    fun mediumList(): List<MediumContent>

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

        override fun mediumList(): List<MediumContent> {
            val result = mutableListOf<MediumContent>()
            for (i in mPositionsList.indices) {
                val isChanged: Boolean
                val value = if (i == mSelectedIndex) {
                    isChanged = true
                    mChangedField
                } else {
                    isChanged = false
                    ""
                }
                result.add(
                    MediumContent.Base(
                        value,
                        mPositionsList[i],
                        isChanged
                    )
                )
            }
            return result
        }
    }
}