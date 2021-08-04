package com.human_developing_soft.unitconverter.domain

interface MediumContent {

    fun addValue(value: String): MediumContent

    fun mapToResponse(units: UnitList): DomainResponse

    class Base(
        private val mValue: String,
        private val mPosition: Int
    ) : MediumContent {
        override fun addValue(value: String) = if (mValue.isNotEmpty()) {
            throw RuntimeException("Value is not empty!")
        } else {
            Base(
                value,
                mPosition
            )
        }

        override fun mapToResponse(units: UnitList): DomainResponse {
            return DomainResponse.Base(
                mValue,
                units.unitsName(),
                mPosition
            )
        }
    }
}