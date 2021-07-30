package com.human_developing_soft.unitconverter.ui.converting

sealed class FieldAccessBehavior {
    object Free: FieldAccessBehavior()

    object Block: FieldAccessBehavior()
}
