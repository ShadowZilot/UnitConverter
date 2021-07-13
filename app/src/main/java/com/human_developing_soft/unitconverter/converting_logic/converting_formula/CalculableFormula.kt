package com.human_developing_soft.unitconverter.converting_logic.converting_formula

import com.human_developing_soft.unitconverter.converting_logic.PsychicUnit
import com.human_developing_soft.unitconverter.units_storage.BaseUnit
import javax.script.ScriptEngine

interface CalculableFormula {
    fun result(): BaseUnit

    class Base(
        private val mExpression: String,
        private val mComputer: ScriptEngine
    ) : CalculableFormula {

        override fun result(): BaseUnit {
            val calculationResult = mComputer.eval(mExpression).toString()
            return PsychicUnit(calculationResult.toDouble())
        }
    }

    class Dummy : CalculableFormula {
        override fun result(): BaseUnit {
            return BaseUnit.Dummy()
        }
    }
}