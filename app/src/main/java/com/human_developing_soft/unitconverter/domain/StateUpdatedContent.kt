package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.MutableUIBundle

interface StateUpdatedContent {
    fun content(index: Int): MutableUIBundle

    class Base(
        valuesList: List<String>,
        indexList: List<Int>
    ): StateUpdatedContent {
        private val mList: MutableList<MutableUIBundle> = mutableListOf()
        init {
            for (i in valuesList.indices) {
                mList.add(
                    MutableUIBundle.Base(
                        valuesList[i],
                        indexList[i]
                    )
                )
            }
        }

        override fun content(index: Int): MutableUIBundle {
            return mList[index]
        }
    }
}