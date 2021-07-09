package com.human_developing_soft.unitconverter.converting_logic.converting_formula

interface StringFormula {
    fun calculableFormula(argument: Float): CalculableFormula

    class Base : StringFormula {

        override fun calculableFormula(argument: Float): CalculableFormula {
            TODO("Not yet implemented")
        }
    }
}