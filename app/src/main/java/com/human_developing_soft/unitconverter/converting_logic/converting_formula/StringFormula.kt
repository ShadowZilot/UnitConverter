package com.human_developing_soft.unitconverter.converting_logic.converting_formula

import javax.script.ScriptEngineManager

interface StringFormula {
    fun calculableFormula(argument: Double): CalculableFormula

    class Base(
        private val mFormula: String,
    ) : StringFormula {

        override fun calculableFormula(argument: Double): CalculableFormula {
            return CalculableFormula.Base(
                mFormula.replace("x", argument.toString()),
                ScriptEngineManager().getEngineByName("js"),
            )
        }
    }

    class Dummy : StringFormula {
        override fun calculableFormula(argument: Double): CalculableFormula {
            return CalculableFormula.Dummy()
        }
    }
}