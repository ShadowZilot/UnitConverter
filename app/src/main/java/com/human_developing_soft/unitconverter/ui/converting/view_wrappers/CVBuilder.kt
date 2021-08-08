package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.human_developing_soft.unitconverter.databinding.ConvertingItemBinding

interface CVBuilder {

    fun buildCV(deletingIndex: Int): ConvertingView

    fun deleteCV(deletingIndex: Int)

    class Base(
        private val mLayout: ViewGroup,
        private val mSpinnerValues: Array<String>
    ) : CVBuilder {
        override fun buildCV(deletingIndex: Int): ConvertingView {
            val cv = ConvertingItemBinding
                .inflate(
                    LayoutInflater
                        .from(mLayout.context)
                )
            mLayout.addView(cv.root)
            cv.removeViewBtn.visibility = if (mLayout.childCount > 1) {
                View.VISIBLE
            } else {
                View.GONE
            }
            val spinnerAdapter = ArrayAdapter(
                cv.unitFirstSelector.context,
                android.R.layout.simple_spinner_item,
                mSpinnerValues
            )
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            cv.unitFirstSelector.adapter = spinnerAdapter

            cv.unitInputFirst.tag = FieldBlocker.Free
            cv.unitFirstSelector.tag = FieldBlocker.Free
            return ConvertingView.Base(
                cv,
                deletingIndex
            )
        }

        override fun deleteCV(deletingIndex: Int) {
            mLayout.removeViewAt(deletingIndex)
        }
    }
}