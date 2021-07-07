package com.human_developing_soft.unitconverter

import com.human_developing_soft.unitconverter.converting_logic.ConvertingFactor
import com.human_developing_soft.unitconverter.converting_logic.PsychicUnit
import com.human_developing_soft.unitconverter.converting_logic.UnitConverter
import junit.framework.Assert.assertEquals
import org.junit.Test

class UnitConverterTest {
    private val mConverter = UnitConverter.Base()

    @Test
    fun meterToKilometer() {
        val meter = PsychicUnit(1500f,
                ConvertingFactor())
        val kilometer = mConverter.convertedUnit(meter,
                ConvertingFactor(0.001f))

        assertEquals(1.5f, kilometer.value())
    }

    @Test
    fun centimeterToKilometer() {
        val centimeter = PsychicUnit(1000f,
                ConvertingFactor(100f))
        val kilometer = mConverter.convertedUnit(centimeter,
                ConvertingFactor(0.001f))

        assertEquals(0.01f, kilometer.value())
    }

    @Test
    fun millimeterToCentimeter() {
        val millimeter = PsychicUnit(10f,
                ConvertingFactor(1000f))
        val centimeter = mConverter.convertedUnit(millimeter,
                ConvertingFactor(100f))

        assertEquals(1f, centimeter.value())
    }

    @Test
    fun inchesToKilometer() {
        val inches = PsychicUnit(25f,
                ConvertingFactor(39.3700787402f))
        val kilometer = mConverter.convertedUnit(inches,
                ConvertingFactor(0.001f))

        assertEquals(0.000635f, kilometer.value())
    }
}