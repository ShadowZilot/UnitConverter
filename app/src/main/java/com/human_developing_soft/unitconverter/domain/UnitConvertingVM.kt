package com.human_developing_soft.unitconverter.domain

import androidx.lifecycle.ViewModel

class UnitConvertingVM(
    private val mFields: FieldsCommunicator
) : ViewModel(), Observer {

    init {
        mFields.addObserver(this)
    }

    override fun update(content: UnitTextBundle) {
        content.updateField()
    }
}