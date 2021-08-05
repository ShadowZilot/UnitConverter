package com.human_developing_soft.unitconverter.domain

interface ConvertingDomainHolder : ConvertingEventSubject {

    fun updateContent(content: List<DomainResponse>)

    class Base(
        private val mContent: MutableList<DomainResponse>
    ) : ConvertingDomainHolder {
        private val mListObservers = mutableListOf<ConvertingEventListener>()

        override fun updateContent(content: List<DomainResponse>) {
            mContent.clear()
            mContent.addAll(content)
            mListObservers.forEach {
                it.onConvertingFinished(mContent)
            }
        }

        override fun addObserver(observer: ConvertingEventListener) {
            mListObservers.add(observer)
            mListObservers.forEach {
                it.onConvertingFinished(mContent)
            }
        }

        override fun removeObserver(observer: ConvertingEventListener) {
            mListObservers.add(observer)
        }
    }
}