package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.widget.Button

interface AddButtonManager {

    fun addObserver(observer: AddViewEventListener)

    fun removeObserver(observer: AddViewEventListener)

    class Base(
        button: Button,
    ): AddButtonManager {
        private val mObservers = mutableListOf<AddViewEventListener>()
        init {
            button.setOnClickListener {
                mObservers.forEach {
                    it.onAddView()
                }
            }
        }

        override fun addObserver(observer: AddViewEventListener) {
            mObservers.add(observer)
        }

        override fun removeObserver(observer: AddViewEventListener) {
            mObservers.remove(observer)
        }
    }
}