package com.human_developing_soft.unitconverter.domain

interface Subject {
    fun addObserver(o: Observer)

    fun removeObserver(o: Observer)

    fun notifyObservers(content: UnitTextBundle)

    class Base(
        private val mListOfObservers: MutableList<Observer>
    ): Subject {

        constructor(): this(mutableListOf())

        override fun addObserver(o: Observer) {
            mListOfObservers.add(o)
        }

        override fun removeObserver(o: Observer) {
            mListOfObservers.remove(o)
        }

        override fun notifyObservers(content: UnitTextBundle) {
            for (observer in mListOfObservers) {
                observer.update(content)
            }
        }
    }
}