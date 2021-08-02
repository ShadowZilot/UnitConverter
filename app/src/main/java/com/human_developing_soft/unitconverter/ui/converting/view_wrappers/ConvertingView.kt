package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.databinding.ConvertingItemBinding

interface ConvertingView {

    class Base(
        private val mBinding: ConvertingItemBinding,
        deletingIndex: Int,
        deletableCode: Int
    ): ConvertingView {

    }
}