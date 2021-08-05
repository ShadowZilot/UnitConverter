package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.OnUiChangedListener

interface ConvertingViewModel: OnUiChangedListener {
    fun addObserver(observer: ConvertingEventListener)

    fun removeObserver(observer: ConvertingEventListener)
}