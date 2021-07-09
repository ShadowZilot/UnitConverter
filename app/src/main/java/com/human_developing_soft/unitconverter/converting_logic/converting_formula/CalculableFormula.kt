package com.human_developing_soft.unitconverter.converting_logic.converting_formula

import com.human_developing_soft.unitconverter.units_storage.BaseUnit

interface CalculableFormula {
    fun result(): BaseUnit

    class Base() : CalculableFormula {

        override fun result(): BaseUnit {
            TODO("Not yet implemented")
        }
    }
}