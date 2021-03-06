package com.human_developing_soft.unitconverter.domain

interface MediumContent {

    fun addValue(value: String): MediumContent

    fun mapToResponse(): DomainResponse

    class Base(
        private val mValue: String,
        private val mPosition: Int,
        private val mIsChanged: Boolean
    ) : MediumContent {
        override fun addValue(value: String) = if (mValue.isNotEmpty()) {
            throw RuntimeException("Value is not empty!")
        } else {
            Base(
                value,
                mPosition,
                mIsChanged
            )
        }

        override fun mapToResponse(): DomainResponse {
            val response = DomainResponse.Base(
                mValue,
                mPosition
            )
            return if (mIsChanged) {
                NonChangedDomainResponse(response)
            } else {
                response
            }
        }
    }
}