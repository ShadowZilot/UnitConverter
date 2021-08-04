package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.StringFormula
import com.human_developing_soft.unitconverter.domain.ConvertingHelperBundle
import com.human_developing_soft.unitconverter.domain.FakeUnitList
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class UiContentHolderTest : TestCase() {

    @Test
    fun mainObjectTest() {
        val holder = UiContentHolder.Base(
            "10",
            listOf(
                0, 1
            ),
            0
        )
        val expected = ConvertingHelperBundle.Base(
            "10",
            FormulaShell.Base(
                StringFormula.Base(
                    "x*1",
                ),
                StringFormula.Base(
                    "x/1"
                )
            )
        )
        val actual = holder.mainObject(
            FakeUnitList()
        )
        assert(
            expected.value() == actual.value() && expected.shells() == actual.shells()
        )
    }
}
