package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.human_developing_soft.unitconverter.ui.converting.FieldAccessBehavior

interface FieldTextWatcher: TextWatcher {
    class Base(
        private val mObserver: FieldChangesObserver,
        private val mEditText: EditText
    ) : FieldTextWatcher {
        init {
            mEditText.tag = FieldAccessBehavior.Free
            mEditText.addTextChangedListener(this)
        }

        override fun beforeTextChanged(s: CharSequence?,
                                       start: Int,
                                       count: Int,
                                       after: Int) {}

        override fun onTextChanged(s: CharSequence?,
                                   start: Int,
                                   before: Int,
                                   count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (mEditText.tag == FieldAccessBehavior.Free) {
                mObserver.updateField(s.toString())
            }
        }
    }
}