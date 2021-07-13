package com.human_developing_soft.unitconverter.converting_logic

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.ConvertingObject
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.converting_logic.converting_formula.StringFormula
import com.human_developing_soft.unitconverter.units_storage.BaseUnit

class PsychicUnit(
    private val mValue: Double,
    private val mConvertingObject: ConvertingObject
) : BaseUnit() {

    constructor(
        value: Double,
    ): this(
        value, ConvertingObject.Dummy()
    )

    constructor(
        baseUnit: BaseUnit,
        formulaToCurrent: StringFormula
    ): this(baseUnit.value(), ConvertingObject.Base(formulaToCurrent))

    constructor(
        value: Double,
        formulaToCurrent: StringFormula,
        formulaToBase: StringFormula
    ): this(value, ConvertingObject.Base(formulaToCurrent, formulaToBase))

    override fun convertToBase(): BaseUnit {
        return mConvertingObject
            .baseUnit(mValue)
    }

    override fun value(): Double {
        return mConvertingObject
            .currentUnit(mValue)
            .value()
    }
}