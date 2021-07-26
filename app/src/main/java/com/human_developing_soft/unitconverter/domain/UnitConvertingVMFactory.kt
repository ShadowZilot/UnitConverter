package com.human_developing_soft.unitconverter.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UnitConvertingVMFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UnitConvertingVM() as T
    }
}