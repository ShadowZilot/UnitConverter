package com.human_developing_soft.unitconverter.domain

interface ConvertingViewModel {
    fun addObserver(observer: ConvertingEventListener)

    fun removeObserver(observer: ConvertingEventListener)
}