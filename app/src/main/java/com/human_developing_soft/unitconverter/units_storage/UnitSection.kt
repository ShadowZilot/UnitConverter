package com.human_developing_soft.unitconverter.units_storage

import com.human_developing_soft.unitconverter.units_storage.data_loading.PrimaryUnit

class UnitSection(
    private val mListOfUnits: List<PrimaryUnit>
): Iterator<PrimaryUnit> {
    private var mCurrentUnit = 0

    override fun next() = mListOfUnits[mCurrentUnit++]

    override fun hasNext() = if (mCurrentUnit < mListOfUnits.size) {
        true
    } else {
        mCurrentUnit = 0
        false
    }
}