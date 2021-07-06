package com.human_developing_soft.unitconverter

import com.human_developing_soft.unitconverter.domain.UnitConverter
import com.human_developing_soft.unitconverter.units_storage.PsychicUnit
import junit.framework.TestCase
import org.junit.Test

class UnitConverter : TestCase() {
    private val mConverter = UnitConverter.Base()

    @Test
    fun meterToKilometer() {
        val meter = PsychicUnit(1500f, 1f)
        val kilometer = mConverter.convertedUnit(meter, 1000f)
        assertEquals(kilometer.value(), 1.5f)
    }

    @Test
    fun centimeterToKilometer() {
        val centimeter = PsychicUnit(1000f, 100f)
        val kilometer = mConverter.convertedUnit(centimeter, 1000f)
        assertEquals(kilometer.value(), 0.01f)
    }
}