package com.human_developing_soft.unitconverter.domain

interface ConvertingHandler: ConvertingEventSubject {

    fun implementCalculations(preparedList: PreparedContent)

    class Base(
        private val mUnits: UnitList
    ) : ConvertingHandler {
        private var mConvertingData = ConvertingDomainHolder.Base(
            mutableListOf(
                DomainResponse.Base(
                    "",
                    mUnits.unitsName(),
                    0
                ),
                DomainResponse.Base(
                    "",
                    mUnits.unitsName(),
                    1
                )
            )
        )

        override fun addObserver(observer: ConvertingEventListener) {
            mConvertingData.addObserver(observer)
        }

        override fun removeObserver(observer: ConvertingEventListener) {
            mConvertingData.removeObserver(observer)
        }

        override fun implementCalculations(preparedList: PreparedContent) {
            val valuesList = preparedList
                .convertingObject()
                .convertAll()
            val content = preparedList.content() as MutableList<MediumContent>
            for (i in valuesList.indices) {
                try {
                    content[i].addValue(
                        valuesList[i]
                    )
                } catch (e: RuntimeException) {
                    try {
                        content[i + 1] = content[i + 1].addValue(
                            valuesList[i + 1]
                        )
                    } catch (e: RuntimeException) {
                        break
                    }
                }
            }
            mConvertingData.updateContent(
                content.map {
                    it.mapToResponse(mUnits)
                }
            )
        }
    }
}