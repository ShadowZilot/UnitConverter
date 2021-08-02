package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

interface PreBuildView {

    fun build()

    class Base(

    ): PreBuildView {
        override fun build() {

        }
    }
}