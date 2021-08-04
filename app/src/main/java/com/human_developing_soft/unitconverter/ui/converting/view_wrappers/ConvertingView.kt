package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import android.view.View
import android.widget.AdapterView
import androidx.core.widget.addTextChangedListener
import com.human_developing_soft.unitconverter.databinding.ConvertingItemBinding
import com.human_developing_soft.unitconverter.domain.DomainResponse

interface ConvertingView {

    fun notifyDeletingListener(listener: OnCVDelete)

    fun notifyUiListener(listener: OnCVChanged)

    fun bindContent(content: DomainResponse)

    fun currentSelectorPosition(): Int

    class Base(
        private val mBinding: ConvertingItemBinding,
        private val mDeletingIndex: Int
    ): ConvertingView {
        private var mUiListener: OnCVChanged = object : OnCVChanged {
            override fun onChanged(fieldValue: String,
                                   selectedIndex: Int) {
                // do nothing
            }
        }
        private var mListener: OnCVDelete = object : OnCVDelete {
            override fun onDelete(deletingIndex: Int) {
                // do nothing
            }
        }

        init {
            mBinding.unitInputFirst.addTextChangedListener {
                mUiListener.onChanged(it.toString(),
                    mDeletingIndex)
            }
            mBinding.unitFirstSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    mUiListener.onChanged(
                        mBinding.unitInputFirst.text.toString(),
                        mDeletingIndex)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }

        override fun notifyDeletingListener(listener: OnCVDelete) {
            mListener.onDelete(mDeletingIndex)
        }

        override fun notifyUiListener(listener: OnCVChanged) {
            mUiListener = listener
        }

        override fun bindContent(content: DomainResponse) {
            content.putContent(
                mBinding.unitInputFirst, mBinding.unitFirstSelector
            )
        }

        override fun currentSelectorPosition(): Int {
            return mBinding.unitFirstSelector.selectedItemPosition
        }
    }
}