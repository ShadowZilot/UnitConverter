package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

interface ConvertingViewHolder : OnBuildFinishListener {

    class Base(
        private val mBuilder: ConvertingViewBuilder,
        private val mCVList: MutableList<ConvertingView> = mutableListOf()
    ) : ConvertingViewHolder {

        /*constructor(oldList: List<DomainContent>, builder: ConvertingViewBuilder) : this(
            builder,
            oldList.map {
                it.mapToUI()
            } as MutableList<ConvertingView>
        )

        init {
            mBuilder.addObserver(this)
        }

        override fun onAddView() {
            mBuilder.build(
                mCVList.size,
                if (mCVList.size > 1) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            )
        }*/

        override fun onBuildFinish(view: ConvertingView) {

        }
    }
}