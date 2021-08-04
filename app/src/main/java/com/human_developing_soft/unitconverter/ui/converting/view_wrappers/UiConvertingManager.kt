package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.widget.Button
import com.human_developing_soft.unitconverter.domain.UiEventListener

interface UiConvertingManager {
    class Base(
        private val mObserver: UiEventListener,
        private val mUiHolder: UiElementsHolder,
        private val mAddButton: Button
    ): UiConvertingManager {

    }
}