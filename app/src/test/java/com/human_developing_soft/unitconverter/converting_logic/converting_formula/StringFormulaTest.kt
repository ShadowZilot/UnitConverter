package com.human_developing_soft.unitconverter.converting_logic.converting_formula

import junit.framework.Assert.assertEquals
import org.junit.Test

class StringFormulaTest {

    @Test
    fun basicFormulaTest() {
        val formula = StringFormula.Base("x + 1")
        val calculableFormula = formula.calculableFormula(2.0)
        assertEquals(3.0, calculableFormula.result().value())
    }
}