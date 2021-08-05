package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.domain.DomainResponse

interface UiElementsHolder: OnCVChanged, OnCVDelete {

    fun implementBuild()

    fun notifyCV(content: List<DomainResponse>)

    fun startNotifyListener(listener: OnUiChangedListener)

    class Base(
        private val mBuilder: CVBuilder
    ): UiElementsHolder {
        private val mElementsList = mutableListOf<ConvertingView>()
        private var mListener: OnUiChangedListener = object : OnUiChangedListener {
            override fun onChanged(uiState: UiContentHolder) {
                // do nothing
            }
        }

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
            while (mElementsList.size < content.size) {
                implementBuild()
            }
            for (i in content.indices) {
                mElementsList[i].bindContent(content[i])
            }
        }

        override fun startNotifyListener(listener: OnUiChangedListener) {
            mListener = listener
        }

        override fun onChanged(
            fieldValue: String,
            selectedIndex: Int,
        ) {
            val positionsList = mutableListOf<Int>()
            mElementsList.forEach {
                positionsList.add(
                    it.currentSelectorPosition()
                )
            }
            mListener.onChanged(
                UiContentHolder.Base(
                    fieldValue,
                    positionsList,
                    selectedIndex
                )
            )
        }


        override fun onDelete(deletingIndex: Int) {
            mBuilder.deleteCV(deletingIndex)
            mElementsList.removeAt(deletingIndex)
        }
    }
}