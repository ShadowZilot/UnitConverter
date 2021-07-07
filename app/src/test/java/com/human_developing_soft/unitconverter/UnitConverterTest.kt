package com.human_developing_soft.unitconverter

import com.human_developing_soft.unitconverter.domain.UnitConverter
import com.human_developing_soft.unitconverter.units_storage.PsychicUnit
import junit.framework.Assert.assertEquals
import org.junit.Test

class UnitConverterTest {
    private val mConverter = UnitConverter.Base()

    @Test
    fun meterToKilometer() {
        val meter = PsychicUnit(1500f, 1f)
        val kilometer = mConverter.convertedUnit(meter, 0.001f)
        assertEquals(1.5f, kilometer.value())
    }

    @Test
    fun centimeterToKilometer() {
        val centimeter = PsychicUnit(1000f, 100f)
        val kilometer = mConverter.convertedUnit(centimeter, 0.001f)
        assertEquals(0.01f, kilometer.value())
    }

    @Test
    fun millimeterToCentimeter() {
        val millimeter = PsychicUnit(10f, 1000f)
        val centimeter = mConverter.convertedUnit(millimeter, 100f)
        assertEquals(1f, centimeter.value())
    }

    @Test
    fun inchesToKilometer() {
        val inches = PsychicUnit(25f, 39.3700787402f)
        val kilometer = mConverter.convertedUnit(inches, 0.001f)
        assertEquals(0.000635, kilometer.value())
    }
}