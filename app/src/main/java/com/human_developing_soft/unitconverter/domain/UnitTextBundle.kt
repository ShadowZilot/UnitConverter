package com.human_developing_soft.unitconverter.domain

import android.widget.EditText

interface UnitTextBundle {
    fun updateField()

    class Base(
        private val mTextValue: String,
        private val mOtherEditText: EditText
    ) : UnitTextBundle {
        override fun updateField() {
            mOtherEditText.tag = FieldBlocker.Blocked
            try {
                mOtherEditText.setText((mTextValue.toFloat() - 10).toString())
            } catch (e: NumberFormatException) {
                mOtherEditText.setText("")
            }
            mOtherEditText.tag = FieldBlocker.Free
        }
    }
}