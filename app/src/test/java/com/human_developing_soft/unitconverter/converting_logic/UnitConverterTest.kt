package com.human_developing_soft.unitconverter.converting_logic

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.StringFormula
import junit.framework.Assert.assertEquals
import org.junit.Test

class UnitConverterTest {

    @Test
    fun simpleConvertTest() {
        val converter = UnitConverter.Base(
            PsychicUnit(
                10.0,
                StringFormula.Base("x*1"),
                StringFormula.Base("x/1")
            ),
            StringFormula.Base("x/3.785412")
        )

        assertEquals(2.6417203728418466, converter.convertedResult().value())
    }

    @Test
    fun lengthConvertingTest() {
        val converter = UnitConverter.Base(
            PsychicUnit(
                1000.0,
                StringFormula.Base("x*100"),
                StringFormula.Base("x/100")
            ),
            StringFormula.Base("x/1000")
        )

        assertEquals(0.01, converter.convertedResult().value())
    }

    @Test
    fun temperatureConvertingTest() {
        val converter = UnitConverter.Base(
            PsychicUnit(
                45.0,
                StringFormula.Base("1.8*x+32"),
                StringFormula.Base("0.5555555555555556*(x-32)")
            ),

            StringFormula.Base("x+273.15")
        )

        assertEquals(280.3722222222222, converter.convertedResult().value())
    }
}