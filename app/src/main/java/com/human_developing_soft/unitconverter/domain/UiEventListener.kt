package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.UiContentHolder

interface UiEventListener {
    fun onUiUpdated(updatedList: UiContentHolder)
}