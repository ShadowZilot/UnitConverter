package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.UiContentHolder

interface PreparedContent {

    fun convertingObject(): ConvertingObject

    fun content(): List<MediumContent>

    class Base(
        private val mUnits: UnitList,
        private val mInitContent: UiContentHolder
    ) : PreparedContent {

        override fun convertingObject() = ConvertingObject.Base(
            mInitContent.mainObject(mUnits),
            mInitContent.formulaShells(mUnits)
        )

        override fun content() = mInitContent.mediumList()
    }
}