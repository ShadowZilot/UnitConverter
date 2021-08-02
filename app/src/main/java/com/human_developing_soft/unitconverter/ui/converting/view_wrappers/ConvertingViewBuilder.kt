package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.view.LayoutInflater
import android.view.ViewGroup
import com.human_developing_soft.unitconverter.databinding.ConvertingItemBinding

interface ConvertingViewBuilder {

    fun build(config: PreBuildView)

    fun addObserver(observer: OnBuildFinishListener)

    fun removeObserver(observer: OnBuildFinishListener)

    class Base(
        private val mBuildField: ViewGroup,
    ): ConvertingViewBuilder {
        private val mObservers = mutableListOf<OnBuildFinishListener>()

        override fun build(config: PreBuildView) {
            val view = ConvertingItemBinding.inflate(
                LayoutInflater.from(
                    mBuildField.context
                )
            )
            mBuildField.addView(view.root)
        }

        override fun addObserver(observer: OnBuildFinishListener) {
            mObservers.add(observer)
        }

        override fun removeObserver(observer: OnBuildFinishListener) {
            mObservers.remove(observer)
        }
    }
}