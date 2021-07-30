package com.human_developing_soft.unitconverter.ui.converting

import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.ConvertingBundleManager
import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.UIConvertingBundle

interface ConvertingViewsHolder: BuildEventListener, VDEventListener {

    fun implementBuild()

    class Base(
        private val mConvertingManager: ConvertingBundleManager,
        private val mListener: OverFlowEventListener,
        unitNames: ArrayAdapter<String>,
        buildLayout: ViewGroup
    ): ConvertingViewsHolder {
        private var mAmountOfViews = 0
        private val mViewsBuilder: ConvertingViewsBuilder
        init {
            mViewsBuilder = ConvertingViewsBuilder.Base(
                buildLayout,
                unitNames,
                this,
                this
            )
        }

        override fun implementBuild() {
            if (mAmountOfViews < 4) {
                mViewsBuilder.build(
                    mAmountOfViews > 1,
                    mAmountOfViews.toInt()
                )
                mAmountOfViews++
            }
            mListener.onViewsOverflow(mAmountOfViews > 3)
        }

        override fun onBuildFinish(view: UIConvertingBundle) {
            mConvertingManager.addBundle(view)
        }

        override fun onDelete(index: Int) {
            mConvertingManager.removeBundle(index)
            mAmountOfViews--
            mListener.onViewsOverflow(mAmountOfViews > 3)
        }
    }
}