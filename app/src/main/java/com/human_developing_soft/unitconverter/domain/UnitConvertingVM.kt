package com.human_developing_soft.unitconverter.domainimport androidx.lifecycle.ViewModelclass UnitConvertingVM(    private val mUnitsList: UnitList,    indexPair: UnitIndexPair = UnitIndexPair.Base(0, 0)) : ViewModel(), Observer {    private var mConvertingPair: ConvertingPair = mUnitsList        .convertingFormulaForPair(            indexPair        )    override fun update(content: UnitTextBundle) {        content.updateField(ConvertingHelper.Base(            mConvertingPair        ))    }    fun changeConvertingFormula(index: UnitIndexPair) {        mConvertingPair = mUnitsList.convertingFormulaForPair(index)    }    fun unitNames(): Array<String> {        return mUnitsList.unitsName()    }}