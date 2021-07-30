package com.human_developing_soft.unitconverter.ui.converting.view_wrappers

import com.human_developing_soft.unitconverter.converting_logic.converting_formula.FormulaShell
import com.human_developing_soft.unitconverter.domain.ConvertingHelperBundle

interface BundleManagerResponse {

    fun content(index: Int): MutableUIBundle

    fun mapTo(mapper : (selectorIndex: Int) -> FormulaShell): List<FormulaShell>

    fun mainBundle(mapper: (selectorIndex: Int) -> FormulaShell): ConvertingHelperBundle

    class Base(
        mainValue: ValueUIContent,
        initList: List<ValueUIContent>
    ): BundleManagerResponse {
        private val mMainElement = MutableUIBundle.Base(mainValue)
        private val mList = initList.map {
            MutableUIBundle.Base(
                it
            )
        }

        override fun content(index: Int): MutableUIBundle {
            return mList[index]
        }

        override fun mapTo(mapper: (selectorIndex: Int) -> FormulaShell): List<FormulaShell> {
            val result = mutableListOf<FormulaShell>()
            for (element in mList) {
                result.add(
                    mapper(element.selectorPosition())
                )
            }
            return result
        }

        override fun mainBundle(mapper: (selectorIndex: Int) -> FormulaShell): ConvertingHelperBundle {
                return ConvertingHelperBundle.Base(
                    mMainElement.fieldValue(),
                    mapper(mMainElement.selectorPosition())
                )
        }
    }
}