package com.human_developing_soft.unitconverter.domain

interface UnitIndexPair {
    fun firstIndex(): Int

    fun secondIndex(): Int

    class Base(
        private val mFirstIndex: Int,
        private val mSecondIndex: Int
    ) : UnitIndexPair {
        override fun firstIndex(): Int {
            return mFirstIndex
        }

        override fun secondIndex(): Int {
            return mSecondIndex
        }
    }
}