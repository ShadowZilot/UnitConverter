package com.human_developing_soft.unitconverter.units_storage

class PsychicUnit(
    private val mValue: Float,
    convertingFactor: Float
) : BaseUnit() {
    private val mConvertingFactor = convertingFactor

    constructor(
        baseUnit: BaseUnit,
        convertingFactor: Float
    ) : this(
        baseUnit.value() * convertingFactor,
        convertingFactor
    )

    override fun convertToBase(): BaseUnit {
        // todo fix magic number constant
        return PsychicUnit(mValue / mConvertingFactor, 1f)
    }

    override fun value() = mValue
}