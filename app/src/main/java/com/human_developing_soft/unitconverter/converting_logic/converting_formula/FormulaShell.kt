package com.human_developing_soft.unitconverter.converting_logic.converting_formula

interface FormulaShell {
    fun formulaBase(): StringFormula

    fun formulaCurrent(): StringFormula

    class Base(
        private val mFormulaToCurrent: StringFormula,
        private val mFormulaToBase: StringFormula
    ): FormulaShell {

        constructor(
            formulaToCurrent: StringFormula
        ): this(formulaToCurrent, StringFormula.Dummy())

        override fun formulaBase() = mFormulaToBase

        override fun formulaCurrent() = mFormulaToCurrent
    }
}