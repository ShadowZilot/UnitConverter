package com.human_developing_soft.unitconverter.domain

interface ConvertingHandler {

    fun addObserver(observer: ConvertingEventListener)

    fun removeObserver(observer: ConvertingEventListener)

    fun implementCalculations(preparedList: PreparedContent)

    class Base : ConvertingHandler {
        private val mListObservers = mutableListOf<ConvertingEventListener>()
        private val mConvertingData = ConvertingDomainHolder.Base()

        override fun addObserver(observer: ConvertingEventListener) {
            mListObservers.add(observer)
        }

        override fun removeObserver(observer: ConvertingEventListener) {
            mListObservers.add(observer)
        }

        override fun implementCalculations(preparedList: PreparedContent) {
            // TODO implement this
            // Here we need to connect the calculations results and other data
            // Save it here and send notification to UI
        }
    }
}