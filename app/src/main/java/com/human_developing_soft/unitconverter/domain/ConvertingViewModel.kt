package com.human_developing_soft.unitconverter.domain

interface ConvertingViewModel: UiEventListener {
    fun addObserver(observer: ConvertingEventListener)

    fun removeObserver(observer: ConvertingEventListener)
}