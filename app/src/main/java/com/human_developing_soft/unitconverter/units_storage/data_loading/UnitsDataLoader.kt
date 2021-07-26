package com.human_developing_soft.unitconverter.units_storage.data_loading

import com.human_developing_soft.unitconverter.units_storage.UnitSection

interface UnitsDataLoader {
    suspend fun unitsData(): UnitSection

    class Base(
        private val mJSONReader: UnitDataReader,
    ): UnitsDataLoader {
        override suspend fun unitsData(): UnitSection {
            return UnitSection(
                mJSONReader.dataUnitList()
            )
        }
    }
}