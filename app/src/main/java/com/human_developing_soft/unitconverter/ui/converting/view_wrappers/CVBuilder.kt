package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.human_developing_soft.unitconverter.databinding.ConvertingItemBinding

interface CVBuilder {

    fun buildCV(deletingIndex: Int): ConvertingView

    class Base(
        private val mLayout: ViewGroup,
    ) : CVBuilder {
        override fun buildCV(deletingIndex: Int): ConvertingView {
            val cv = ConvertingItemBinding
                .inflate(
                    LayoutInflater
                        .from(mLayout.context)
                )
            mLayout.addView(cv.root)
            cv.removeViewBtn.visibility = if (mLayout.childCount > 1) {
                View.GONE
            } else {
                View.VISIBLE
            }
            return ConvertingView.Base(
                cv,
                deletingIndex
            )
        }
    }
}