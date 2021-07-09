package com.human_developing_soft.unitconverter.converting_logic

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.ConvertingObject
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.StringFormula
import com.human_developing_soft.unitconverter.units_storage.BaseUnit

class PsychicUnit(
    private val mValue: Float,
    formulaTo: StringFormula,
    formulaFrom: StringFormula
) : BaseUnit() {
    private val mConvertingObject = ConvertingObject.Base(mValue,
        formulaTo, formulaFrom)

    constructor(
        baseUnit: BaseUnit,
        formulaTo: StringFormula,
        formulaFrom: StringFormula
    ) : this(
        baseUnit.value(), formulaTo, formulaFrom
    )

    override fun convertToBase(): BaseUnit {
        return mConvertingObject.baseUnit()
    }

    override fun value() = mValue
}