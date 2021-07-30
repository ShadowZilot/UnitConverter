package com.human_developing_soft.unitconverter.ui.converting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.human_developing_soft.unitconverter.databinding.ConvertingItemBinding
import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.UIConvertingBundle

interface ConvertingViewsBuilder {

    fun build(isDeletingAvailable: Boolean, viewIndex: Int)

    class Base(
        private val mBuildLayout: ViewGroup,
        private val mUnitNames: ArrayAdapter<String>,
        private val mBuildListener: BuildEventListener,
        private val mDeletingListener: VDEventListener
    ) : ConvertingViewsBuilder {

        override fun build(isDeletingAvailable: Boolean, viewIndex: Int) {
            val view = ConvertingItemBinding
                .inflate(
                    LayoutInflater
                        .from(
                            mBuildLayout.context
                        )
                )
            view.removeViewBtn.setOnClickListener {
                mDeletingListener.onDelete(viewIndex)
                mBuildLayout.removeView(view.root)
            }
            view.removeViewBtn.visibility = if (isDeletingAvailable) {
                View.VISIBLE
            } else {
                View.GONE
            }

            view.unitFirstSelector.adapter = mUnitNames
            mBuildLayout.addView(view.root)
            mBuildListener.onBuildFinish(UIConvertingBundle.Base(
                view.unitInputFirst, view.unitFirstSelector
            ))
        }
    }
}