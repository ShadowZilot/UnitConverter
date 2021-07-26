package com.human_developing_soft.unitconverter.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UnitConvertingVMFactory(
    private val mCommunicator: FieldsCommunicator
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        mCommunicator.startObserving()
        return UnitConvertingVM(mCommunicator) as T
    }
}