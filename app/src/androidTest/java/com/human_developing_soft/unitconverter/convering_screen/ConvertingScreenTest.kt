package com.human_developing_soft.unitconverter.convering_screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.human_developing_soft.unitconverter.R
import com.human_developing_soft.unitconverter.ui.converting.MainActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConvertingScreenTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun twoFieldsAtBeginning() {
        onView(withId(R.id.convertingViewList)).check(
            matches(hasChildCount(2))
        )
    }

    @Test
    fun addAnotherField() {
        onView(withId(R.id.addConvertingView)).perform(
            click()
        )
        onView(withId(R.id.convertingViewList)).check(
            matches(hasChildCount(3))
        )
    }

    @Test
    fun basicConverting() {
        onView(
            allOf(
                withParent(withId(R.id.convertingViewList)),
                withParentIndex(0),
                withParent(withId(R.id.convertingView)),
                withParentIndex(1)
            )
        ).perform(typeText("12"))
    }
}