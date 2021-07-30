package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.widget.EditText
import android.widget.Spinner
import com.human_developing_soft.unitconverter.ui.converting.FieldAccessBehavior

interface UIConvertingBundle : ViewsChangesListener {

    fun updateFieldValue(value: String)

    fun updateSelectorValue(value: Int)

    fun setObserver(o: BundleEventListener)

    fun deleteObserver()

    class Base(
        private val mField: EditText,
        private val mUnitSelector: Spinner,
        ): UIConvertingBundle {
            private val mEventManager: ConvertingEventManager
            private var mObserver: BundleEventListener = object : BundleEventListener {
                override fun onBundleUpdate(content: ValueUIContent) {}
            }
            init {
                 mEventManager = ConvertingEventManager.Base(
                    this,
                    mField,
                    mUnitSelector)
            }

        override fun updateFieldValue(value: String) {
            mField.tag = FieldAccessBehavior.Block
            mField.setText(value)
            mField.tag = FieldAccessBehavior.Free
        }

        override fun updateSelectorValue(value: Int) {
            mUnitSelector.setSelection(value)
        }

        override fun setObserver(o: BundleEventListener) {
            mObserver = o
        }

        override fun deleteObserver() {
            mObserver = object : BundleEventListener {
                override fun onBundleUpdate(content: ValueUIContent) {}
            }
        }

        override fun onUIChange(content: ValueUIContent) {
            mObserver.onBundleUpdate(content)
        }
    }
}