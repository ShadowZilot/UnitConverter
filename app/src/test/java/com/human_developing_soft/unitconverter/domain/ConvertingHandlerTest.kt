package com.human_developing_soft.unitconverter.domain

import com.human_developing_soft.unitconverter.ui.converting.view_wrappers.UiContentHolder
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class ConvertingHandlerTest : TestCase() {

    @Test
    fun baseConvertingTest() {
        val handler = ConvertingHandler.Base(
            FakeUnitList()
        )
        handler.addObserver(object : ConvertingEventListener {
            override fun onConvertingFinished(content: List<DomainResponse>) {
                val stringArr = FakeUnitList().unitsName()
                assertEquals(
                    listOf(
                        DomainResponse.Base(
                            "10",
                            stringArr,
                            0
                        ),
                        DomainResponse.Base(
                            "2.6417203728418466",
                            stringArr,
                            1
                        )
                    ),
                    content
                )
            }
        })
        handler.implementCalculations(
            PreparedContent.Base(
                FakeUnitList(),
                UiContentHolder.Base(
                    "10",
                    listOf(
                        0, 1
                    ),
                    0
                )
            )
        )
    }
}