package com.human_developing_soft.unitconverter.domain

interface ConvertingEventListener {
    fun onConvertingFinished(content: List<DomainResponse>)
}