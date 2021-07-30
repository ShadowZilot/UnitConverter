package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

interface MutableUIBundle {

    fun fieldValue(): String

    fun selectorPosition(): Int

    class Base(
        private var mFieldValue: String,
        private val mUnitIndex: Int
    ): MutableUIBundle {
        constructor(initializer: ValueUIContent): this(initializer.textField(),
            initializer.unitIndex())

        override fun fieldValue(): String {
            return mFieldValue
        }

        override fun selectorPosition(): Int {
            return mUnitIndex
        }
    }
}