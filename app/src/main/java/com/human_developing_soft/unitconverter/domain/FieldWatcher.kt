package com.human_developing_soft.unitconverter.domain

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

interface FieldWatcher : TextWatcher {

    class Base(
        private val mSubject: Subject,
        private val mSelfField: EditText,
        private val mOtherField: EditText,
    ) : FieldWatcher {

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (mSelfField.tag == FieldBlocker.Free) {
                mSubject.notifyObservers(
                    UnitTextBundle.Base(
                        s.toString(), mOtherField
                    )
                )
            }
        }
    }
}