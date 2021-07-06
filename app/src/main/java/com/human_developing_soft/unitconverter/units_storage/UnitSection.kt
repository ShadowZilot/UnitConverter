package com.human_developing_soft.unitconverter.units_storage

class UnitSection(
    unitLoader: UnitLoader
) {
    private val mListOfUnits: List<BaseUnit> by lazy {
        unitLoader.units()
    }

    private var mCurrentUnit = 0

    operator fun next() = mListOfUnits[mCurrentUnit++]

    operator fun hasNext() = if (mCurrentUnit < mListOfUnits.size) {
        true
    } else {
        mCurrentUnit = 0
        false
    }
}