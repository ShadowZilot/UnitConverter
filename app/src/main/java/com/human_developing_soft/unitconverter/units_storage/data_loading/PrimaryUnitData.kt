package com.human_developing_soft.unitconverter.units_storage.data_loading

import org.json.JSONObject

data class PrimaryUnitData(
    private val mUnitName: String,
    private val mFormulaToCurrent: String,
    private val mFormulaToBase: String
) : PrimaryUnit {

    constructor(
       jsonUnit: JSONObject
    ): this(
        jsonUnit.getString("name"),
        jsonUnit.getString("formulaTo"),
        jsonUnit.getString("formulaFrom")
    )
}