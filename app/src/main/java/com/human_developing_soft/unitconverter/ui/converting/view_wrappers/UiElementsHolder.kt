package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.domain.DomainResponse

interface UiElementsHolder: OnCVChanged, OnCVDelete {

    fun implementBuild()

    fun notifyCV(content: List<DomainResponse>)

    class Base(
        private val mBuilder: CVBuilder
    ): UiElementsHolder {
        private val mElementsList = mutableListOf<ConvertingView>()

        override fun implementBuild() {
            mElementsList.add(
                mBuilder.buildCV(
                    mElementsList.size
                )
            )
            mElementsList.last().notifyDeletingListener(this)
            mElementsList.last().notifyUiListener(this)
        }

        override fun notifyCV(content: List<DomainResponse>) {
            for (i in content.indices) {
                mElementsList[i].bindContent(content[i])
            }
        }

        override fun onChanged(
            fieldValue: String,
            selectedIndex: Int,
        ) {

        }


        override fun onDelete(deletingIndex: Int) {
            mElementsList.removeAt(deletingIndex)
        }
    }
}