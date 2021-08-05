package com.human_developing_soft.unitconverter.domain

import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.FieldBlocker

interface DomainResponse {

    fun putContent(field: EditText, spinner: Spinner)

    data class Base(
        private val mFieldValue: String,
        private val mSpinnerValue: Array<String>,
        private val mSelectedIndex: Int
    ) : DomainResponse {
        override fun putContent(field: EditText, spinner: Spinner) {
            field.tag = FieldBlocker.Block
            field.setText(mFieldValue)
            val spinnerAdapter = ArrayAdapter(
                spinner.context,
                android.R.layout.simple_spinner_item,
                mSpinnerValue
            )
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.tag = FieldBlocker.Block
            spinner.adapter = spinnerAdapter
            spinner.setSelection(mSelectedIndex)
            spinner.tag = FieldBlocker.Free
            field.tag = FieldBlocker.Free
        }

        override fun toString(): String {
            return "$mFieldValue with index $mSelectedIndex"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Base

            if (mFieldValue != other.mFieldValue) return false
            if (!mSpinnerValue.contentEquals(other.mSpinnerValue)) return false
            if (mSelectedIndex != other.mSelectedIndex) return false

            return true
        }

        override fun hashCode(): Int {
            var result = mFieldValue.hashCode()
            result = 31 * result + mSpinnerValue.contentHashCode()
            result = 31 * result + mSelectedIndex
            return result
        }
    }
}