package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

interface ValueUIContent {

    fun textField(): String

    fun unitIndex(): Int

    class Base(
        private val mFieldText: String,
        private val mSelectorPosition: Int
    ): ValueUIContent {
        override fun textField(): String {
            return mFieldText
        }

        override fun unitIndex(): Int {
            return mSelectorPosition
        }
    }

    class Empty: ValueUIContent {
        override fun textField(): String {
           return "You got access to empty field"
        }

        override fun unitIndex(): Int {
            return 0
        }
    }
}