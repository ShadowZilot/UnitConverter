package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.domain.StateUpdatedContent

interface ConvertingBundleManager : IndexBundleEventListener {

    fun addBundle(bundle: UIConvertingBundle)

    fun removeBundle(removableIndex: Int)

    fun updateState(state: StateUpdatedContent)

    class Base(
        private val mObserver: BMEventListener,
        private val mListOfBundles: MutableList<UIConvertingBundle> = mutableListOf(),
        private val mListOfContents: MutableList<ValueUIContent> = mutableListOf()
    ) : ConvertingBundleManager {
        private var mExceptionIndex = 0

        override fun addBundle(bundle: UIConvertingBundle) {
            bundle.setObserver(
                BundleEventListener.Base(
                    this, mListOfContents.size
                )
            )
            mListOfContents.add(
                ValueUIContent.Empty()
            )
            mListOfBundles.add(
                bundle
            )
        }

        override fun removeBundle(removableIndex: Int) {
            mListOfContents.removeAt(removableIndex)
            mListOfBundles[removableIndex].deleteObserver()
            mListOfBundles.removeAt(removableIndex)
        }

        override fun updateState(state: StateUpdatedContent) {
            mListOfBundles.forEachIndexed { index, item ->
                if (index != mExceptionIndex) {
                    val content = state.content(index)
                    item.updateFieldValue(
                        content.fieldValue()
                    )
                    item.updateSelectorValue(
                        content.selectorPosition()
                    )
                }
            }
        }

        override fun onIndexBundleUpdate(content: ValueUIContent, index: Int) {
            mExceptionIndex = index
            mListOfContents[index] = content
            mObserver.onUiUpdate(
                BundleManagerResponse.Base(
                    content, mListOfContents
                )
            )
        }
    }
}