package com.human_developing_soft.unitconverter.units_storage

import com.human_developing_soft.unitconverter.converting_logic.UnitLoader

class UnitSection(
    unitLoader: UnitLoader
) {
    private val mListOfUnits: List<BaseUnit> = unitLoader.units()

    private var mCurrentUnit = 0

    operator fun next() = mListOfUnits[mCurrentUnit++]

    operator fun hasNext() = if (mCurrentUnit < mListOfUnits.size) {
        true
    } else {
        mCurrentUnit = 0
        false
    }
}