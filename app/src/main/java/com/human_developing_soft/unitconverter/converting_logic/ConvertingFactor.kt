package com.human_developing_soft.unitconverter.converting_logic

private const val sBaseConvertingFactor = 1f

class ConvertingFactor(
    private val mFactor: Float = sBaseConvertingFactor
) {
    operator fun div(unitValue: Float): Float = unitValue / mFactor

    operator fun times(unitValue: Float): Float = unitValue * mFactor
}