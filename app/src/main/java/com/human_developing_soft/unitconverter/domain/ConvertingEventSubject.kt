package com.human_developing_soft.unitconverter.domain

interface ConvertingEventSubject {
    fun addObserver(observer: ConvertingEventListener)

    fun removeObserver(observer: ConvertingEventListener)
}