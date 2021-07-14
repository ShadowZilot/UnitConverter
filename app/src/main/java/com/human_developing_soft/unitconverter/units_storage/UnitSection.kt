package com.human_developing_soft.unitconverter.units_storage

import com.human_developing_soft.unitconverter.units_storage.data_loading.PrimaryUnit

class UnitSection(
    private val mListOfUnits: List<PrimaryUnit>
) {
    private var mCurrentUnit = 0

    operator fun next() = mListOfUnits[mCurrentUnit++]

    operator fun hasNext() = if (mCurrentUnit < mListOfUnits.size) {
        true
    } else {
        mCurrentUnit = 0
        false
    }
}