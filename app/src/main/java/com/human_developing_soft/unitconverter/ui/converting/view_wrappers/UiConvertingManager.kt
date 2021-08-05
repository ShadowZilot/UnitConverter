package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.widget.Button
import com.human_developing_soft.unitconverter.domain.ConvertingEventListener
import com.human_developing_soft.unitconverter.domain.DomainResponse

interface UiConvertingManager: ConvertingEventListener {
    class Base(
        mObserver: OnUiChangedListener,
        private val mUiHolder: UiElementsHolder,
        mAddButton: Button
    ): UiConvertingManager {
        init {
            mUiHolder.startNotifyListener(mObserver)
            mAddButton.setOnClickListener {
                mUiHolder.implementBuild()
            }
        }

        override fun onConvertingFinished(content: List<DomainResponse>) {
            mUiHolder.notifyCV(content)
        }
    }
}