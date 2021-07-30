package com.human_developing_soft.unitconverter.ui.converting

import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.UIConvertingBundle

interface BuildEventListener {
    fun onBuildFinish(view: UIConvertingBundle)
}