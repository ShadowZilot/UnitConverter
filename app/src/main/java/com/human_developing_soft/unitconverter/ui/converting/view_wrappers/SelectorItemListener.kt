package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

interface SelectorItemListener: AdapterView.OnItemSelectedListener {
    class Base(
        private val mObserver: SelectorChangesObserver,
        spinner: Spinner
    ) : SelectorItemListener {
        init {
            spinner.onItemSelectedListener = this
        }

        override fun onItemSelected(parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long) {
            mObserver.updateSelector(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
}