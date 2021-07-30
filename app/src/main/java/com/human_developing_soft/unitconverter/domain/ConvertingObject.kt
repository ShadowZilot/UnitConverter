package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.PsychicUnit
import com.human_developing_soft.unitconverter.converting_logic.UnitConverter
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.ConvertingObject.Base
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell

interface ConvertingObject {

    fun convertAll(): List<String>

    class Base(
        private val mMainBundle: ConvertingHelperBundle,
        private val mListOfFormulaShell: List<FormulaShell>
    ): ConvertingObject {
        override fun convertAll(): List<String> {
            val result = mutableListOf<String>()
            for (shell in mListOfFormulaShell) {
                try {
                    result.add(
                        UnitConverter.Base(
                            PsychicUnit(
                                mMainBundle.value(),
                                Base(
                                    shell
                                )
                            ),
                            mMainBundle.shells().formulaCurrent()
                        ).convertedResult().value().toString()
                    )
                } catch (e: NumberFormatException) {
                    result.add("")
                }
            }
            return result
        }
    }
}