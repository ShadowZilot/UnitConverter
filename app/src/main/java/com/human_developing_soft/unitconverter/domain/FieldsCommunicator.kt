package com.human_developing_soft.unitconverter.domain

import android.widget.EditText

interface FieldsCommunicator {

    fun addObserver(o: Observer)

    fun removeObserver(o: Observer)

    fun startObserving()

    class Base(
        private val mFirstEditText: EditText,
        private val mSecondEditText: EditText,
        private val mSubject: Subject,
    ) : FieldsCommunicator {
        override fun addObserver(o: Observer) {
            mSubject.addObserver(o)
        }

        override fun removeObserver(o: Observer) {
            mSubject.removeObserver(o)
        }

        override fun startObserving() {
            mFirstEditText.tag = FieldBlocker.Free
            mFirstEditText.addTextChangedListener(
                FieldWatcher.Base(mSubject, mFirstEditText, mSecondEditText)
            )
            mSecondEditText.tag = FieldBlocker.Free
            mSecondEditText.addTextChangedListener(
                FieldWatcher.Base(mSubject, mSecondEditText, mFirstEditText)
            )
        }
    }
}