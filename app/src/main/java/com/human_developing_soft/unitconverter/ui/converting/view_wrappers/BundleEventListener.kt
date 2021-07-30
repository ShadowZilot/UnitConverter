package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

interface BundleEventListener {
    fun onBundleUpdate(content: ValueUIContent)

    class Base(
        private val mObserver: IndexBundleEventListener,
        private val mSelfIndex: Int
    ): BundleEventListener {
        override fun onBundleUpdate(content: ValueUIContent) {
            mObserver.onIndexBundleUpdate(content, mSelfIndex)
        }
    }
}