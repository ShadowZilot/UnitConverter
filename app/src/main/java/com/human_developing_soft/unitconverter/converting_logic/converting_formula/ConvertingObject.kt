package com.human_developing_soft.unitconverter.converting_logic.converting_formula

import com.human_developing_soft.unitconverter.units_storage.BaseUnit

interface ConvertingObject {
    fun baseUnit(unitValue: Double): BaseUnit

    fun currentUnit(unitValue: Double): BaseUnit

    class Base(
        private val mFormulaShell: FormulaShell
    ) : ConvertingObject {

        constructor(
            formulaToCurrent: StringFormula
        ): this(FormulaShell.Base(formulaToCurrent))

        constructor(
            formulaToCurrent: StringFormula,
            formulaToBase: StringFormula
        ): this(FormulaShell.Base(formulaToCurrent, formulaToBase))

        override fun baseUnit(unitValue: Double): BaseUnit {
            return mFormulaShell
                .formulaBase()
                .calculableFormula(unitValue)
                .result()
        }

        override fun currentUnit(unitValue: Double): BaseUnit {
            return mFormulaShell
                .formulaCurrent()
                .calculableFormula(unitValue)
                .result()
        }
    }

    class Dummy : ConvertingObject {
        override fun baseUnit(unitValue: Double): BaseUnit {
            return BaseUnit.Dummy(unitValue)
        }

        override fun currentUnit(unitValue: Double): BaseUnit {
            return BaseUnit.Dummy(unitValue)
        }
    }
}