package com.human_developing_soft.unitconverter.domain

interface ConvertingCalculations {

    fun calculate()

    class Base(

    ): ConvertingCalculations {
        override fun calculate() {

        }
    }
}