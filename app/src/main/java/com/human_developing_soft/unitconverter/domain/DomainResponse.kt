package com.human_developing_soft.unitconverter.domain

import android.widget.EditText
import android.widget.Spinner
import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.FieldBlocker

interface DomainResponse {

    fun putContent(field: EditText, spinner: Spinner)

    data class Base(
        private val mFieldValue: String,
        private val mSelectedIndex: Int
    ) : DomainResponse {
        override fun putContent(field: EditText, spinner: Spinner) {
            field.tag = FieldBlocker.Block
            spinner.tag = FieldBlocker.Block
            field.setText(mFieldValue)
            spinner.setSelection(mSelectedIndex)
            field.tag = FieldBlocker.Free
            spinner.tag = FieldBlocker.Free
        }

        override fun toString(): String {
            return "$mFieldValue with index $mSelectedIndex"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Base

            if (mFieldValue != other.mFieldValue) return false
            if (mSelectedIndex != other.mSelectedIndex) return false

            return true
        }

        override fun hashCode(): Int {
            var result = mFieldValue.hashCode()
            result = 31 * result + mSelectedIndex
            return result
        }
    }
}