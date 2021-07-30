package com.human_developing_soft.unitconverter.ui.converting

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.ConvertingBundleManager

interface AddButtonManager: View.OnClickListener {
    class Base(
        layout: ViewGroup,
        listener: OverFlowEventListener,
        convertingManager: ConvertingBundleManager,
        unitsNames: ArrayAdapter<String>,
        addButton: Button
    ): AddButtonManager {
        private val mHolder: ConvertingViewsHolder
        init {
            addButton.setOnClickListener { this.onClick(it) }
            mHolder = ConvertingViewsHolder.Base(
                convertingManager,
                listener,
                unitsNames,
                layout
            )
        }

        override fun onClick(v: View?) {
            mHolder.implementBuild()
        }
    }
}