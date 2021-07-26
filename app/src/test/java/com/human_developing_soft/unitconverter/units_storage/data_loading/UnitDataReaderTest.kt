package com.human_developing_soft.unitconverter.units_storage.data_loading

import junit.framework.TestCase

class UnitDataReaderTest : TestCase() {
    fun testLoadVolumeUnit() {
        val reader = UnitDataReader.Base(FakeUnitDataJson())
        for (unit in reader.dataUnitList()) {
            println(unit.toString())
        }
    }

    class FakeUnitDataJson : UnitDataJSON {
        override fun jsonString(): String {
            return """
                {
                  "units": [
                    {
                      "name": "liter",
                      "formulaTo": "x*1",
                      "formulaFrom": "x/1"
                    },

                    {
                      "name": "gallon",
                      "formulaTo": "x*3.785412",
                      "formulaFrom": "x/3.785412"
                    },

                    {
                      "name": "cubic meter",
                      "formulaTo": "x*1000",
                      "formulaFrom": "x/1000"
                    }
                  ]
                }
            """.trimIndent()
        }
    }

}