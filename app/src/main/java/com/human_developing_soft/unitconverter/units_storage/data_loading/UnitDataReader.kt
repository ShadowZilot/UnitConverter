package com.human_developing_soft.unitconverter.units_storage.data_loading

import org.json.JSONObject

interface UnitDataReader {
    fun dataUnitList(): List<PrimaryUnit>

    class Base(
        private val mJSONFile: UnitDataJSON
    ) : UnitDataReader {
        override fun dataUnitList(): List<PrimaryUnit> {
            val result = mutableListOf<PrimaryUnit>()
            val unitsArray = JSONObject(
                mJSONFile.jsonString()
            ).getJSONArray("units")

            for (i in 0 until unitsArray.length()) {
                result.add(
                    PrimaryUnitData(unitsArray
                        .getJSONObject(i))
                )
            }

            return result
        }
    }
}