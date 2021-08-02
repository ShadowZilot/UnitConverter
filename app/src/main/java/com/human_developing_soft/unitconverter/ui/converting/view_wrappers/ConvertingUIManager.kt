package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

interface ConvertingUIManager: AddViewEventListener {
    class Base(
        private val mButtonManager: AddButtonManager,
        private val mConvertingHolder: ConvertingViewHolder
    ): ConvertingUIManager {

        init {
            mButtonManager.addObserver(this)
        }

        override fun onAddView() {

        }
    }
}