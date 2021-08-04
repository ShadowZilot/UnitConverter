package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.units_storage.data_loading.PrimaryUnitData

class FakeUnitList : UnitList {
    private val mUnits = UnitList.Base(
        listOf(
            PrimaryUnitData(
                "Litre",
                "x*1",
                "x/1"
            ),
            PrimaryUnitData(
                "US gallon",
                "x*3.785412",
                "x/3.785412"
            ),
            PrimaryUnitData(
                "Cubic meter",
                "x*1000",
                "x/1000"
            ),
            PrimaryUnitData(
                "Cubic inches",
                "x*0.0163871",
                "x*61.0237440947"
            )
        )
    )

    override fun unitsName(): Array<String> {
        return mUnits.unitsName()
    }

    override fun shellByIndex(index: Int): FormulaShell {
        return mUnits.shellByIndex(index)
    }
}