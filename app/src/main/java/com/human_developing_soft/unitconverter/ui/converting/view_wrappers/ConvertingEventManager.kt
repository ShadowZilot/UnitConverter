package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.widget.EditText
import android.widget.Spinner

interface ConvertingEventManager: FieldChangesObserver, SelectorChangesObserver {
    class Base(
        private val mObserver: ViewsChangesListener,
        private val mEditText: EditText,
        private val mSpinner: Spinner
    ): ConvertingEventManager {
        init {
            FieldTextWatcher.Base(this,
                mEditText)
            SelectorItemListener.Base(this,
                mSpinner)
        }

        override fun updateField(fieldValue: String) {
            mObserver.onUIChange(
                ValueUIContent.Base(
                    fieldValue,
                    mSpinner.selectedItemPosition
                )
            )
        }

        override fun updateSelector(selectorValue: Int) {
            mObserver.onUIChange(
                ValueUIContent.Base(
                    mEditText.text.toString(),
                    selectorValue
                )
            )
        }
    }
}