package com.human_developing_soft.unitconverter.domain

import android.widget.EditText

interface FieldsCommunicator {

    fun addObserver(o: Observer)

    fun removeObserver(o: Observer)

    fun resumeObserving()

    fun pauseObserving()

    class Base(
        private val mFirstEditText: EditText,
        private val mSecondEditText: EditText,
        private val mSubject: Subject,
    ) : FieldsCommunicator {

        init {
            mFirstEditText.addTextChangedListener(
                FieldWatcher.Base(mSubject, mFirstEditText, mSecondEditText)
            )
            mSecondEditText.addTextChangedListener(
                FieldWatcher.Base(mSubject, mSecondEditText, mFirstEditText)
            )
        }

        override fun addObserver(o: Observer) {
            mSubject.addObserver(o)
        }

        override fun removeObserver(o: Observer) {
            mSubject.removeObserver(o)
        }

        override fun resumeObserving() {
            mFirstEditText.tag = FieldBlocker.Free
            mSecondEditText.tag = FieldBlocker.Free
        }

        override fun pauseObserving() {
            mFirstEditText.tag = FieldBlocker.Blocked
            mSecondEditText.tag = FieldBlocker.Blocked
        }
    }
}