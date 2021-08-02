package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.StringFormula
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class ConvertingObjectTest : TestCase() {

    @Test
    fun baseTest() {
        val converting = ConvertingObject.Base(
            ConvertingHelperBundle.Base(
                "10",
                FormulaShell.Base(
                    StringFormula.Base(
                        "x/1"
                    ),
                    StringFormula.Base(
                        "x*1"
                    )
                )
            ),
            listOf(
                FormulaShell.Base(
                    StringFormula.Base(
                        "x*3.785412"
                    ),
                    StringFormula.Base(
                        "x/3.785412"
                    )
                )
            )
        )
        val result = converting.convertAll()
        assertEquals(listOf("2.6417203728418466"), result)
    }

    @Test
    fun emptyFieldTest() {
        val converting = ConvertingObject.Base(
            ConvertingHelperBundle.Base(
                "",
                FormulaShell.Base(
                    StringFormula.Base(
                        "x/1"
                    ),
                    StringFormula.Base(
                        "x*1"
                    )
                )
            ),
            listOf(
                FormulaShell.Base(
                    StringFormula.Base(
                        "x*3.785412"
                    ),
                    StringFormula.Base(
                        "x/3.785412"
                    )
                )
            )
        )
        val result = converting.convertAll()
        assertEquals(listOf(""), result)
    }

    @Test
    fun sameFieldTest() {
        val converting = ConvertingObject.Base(
            ConvertingHelperBundle.Base(
                "1",
                FormulaShell.Base(
                    StringFormula.Base(
                        "x*0.0163871"
                    ),
                    StringFormula.Base(
                        "x*61.0237440947"
                    )
                )
            ),
            listOf(
                FormulaShell.Base(
                    StringFormula.Base(
                        "x*0.0163871"
                    ),
                    StringFormula.Base(
                        "x*61.0237440947"
                    )
                )
            )
        )
        val result = converting.convertAll()
        assertEquals(listOf("1"), result)
    }

    @Test
    fun manyValuesTest() {
        val converting = ConvertingObject.Base(
            ConvertingHelperBundle.Base(
                "10",
                FormulaShell.Base(
                    StringFormula.Base(
                        "x/1"
                    ),
                    StringFormula.Base(
                        "x*1"
                    )
                )
            ),
            listOf(
                FormulaShell.Base(
                    StringFormula.Base(
                        "x*3.785412"
                    ),
                    StringFormula.Base(
                        "x/3.785412"
                    )
                ),
                FormulaShell.Base(
                    StringFormula.Base(
                        "x*1000"
                    ),
                    StringFormula.Base(
                        "x/1000"
                    )
                )
            )
        )
        val result = converting.convertAll()
        assertEquals(
            listOf(
                "2.6417203728418466",
                "0.01"
            ), result
        )
    }
}