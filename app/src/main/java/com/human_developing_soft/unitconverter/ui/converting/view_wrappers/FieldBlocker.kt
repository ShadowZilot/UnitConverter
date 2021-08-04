package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

sealed class FieldBlocker {
    object Block: FieldBlocker()

    object Free: FieldBlocker()
}
