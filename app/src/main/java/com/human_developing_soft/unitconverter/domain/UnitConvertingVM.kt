package com.human_developing_soft.unitconverter.domain

import androidx.lifecycle.ViewModel

class UnitConvertingVM: ViewModel(), Observer {
    override fun update(content: UnitTextBundle) {
        content.updateField()
    }
}