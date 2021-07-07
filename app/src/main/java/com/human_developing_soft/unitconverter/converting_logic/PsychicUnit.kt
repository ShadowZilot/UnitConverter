package com.human_developing_soft.unitconverter.converting_logic

import com.human_developing_soft.unitconverter.units_storage.BaseUnit

class PsychicUnit(
    private val mValue: Float,
    convertingFactor: ConvertingFactor
) : BaseUnit() {
    private val mConvertingFactor = convertingFactor

    constructor(
            baseUnit: BaseUnit,
            convertingFactor: ConvertingFactor
    ) : this(
         convertingFactor * baseUnit.value(),
        convertingFactor
    )

    override fun convertToBase(): BaseUnit {
        return PsychicUnit(mConvertingFactor / mValue, ConvertingFactor())
    }

    override fun value() = mValue
}