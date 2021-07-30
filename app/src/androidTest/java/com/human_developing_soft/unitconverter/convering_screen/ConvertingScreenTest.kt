package com.human_developing_soft.unitconverter.convering_screen

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.human_developing_soft.unitconverter.ui.converting.MainActivity
import com.human_developing_soft.unitconverter.R
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConvertingScreenTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun convertingLitreToCubicMeter() {
        onView(withId(R.id.unit_second_selector)).perform(
            click()
        )

        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Cubic meter")
            )
        ).perform(click())

        onView(withId(R.id.unit_input_first)).perform(
            typeText("5")
        )
        onView(withId(R.id.unit_input_second)).check(
            matches(withText("0.005"))
        )
    }

    @Test
    fun convertingCubicInchesToLitre() {
        onView(
            withId(R.id.unit_first_selector)
        ).perform(click())
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("US gallon")
            )
        ).perform(click())
        onView(
            withId(R.id.unit_second_selector)
        ).perform(click())
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Cubic inches")
            )
        ).perform(click())

        onView(withId(R.id.unit_input_first)).perform(
            typeText("12")
        )
        onView(withId(R.id.unit_input_second)).check(
            matches(withText("2772.0001581720785"))
        )
    }

    @Test
    fun convertingNegativeVolume() {
        onView(
            withId(R.id.unit_first_selector)
        ).perform(click())
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Cubic meter")
            )
        ).perform(click())
        onView(
            withId(R.id.unit_second_selector)
        ).perform(click())
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("US gallon")
            )
        ).perform(click())

        onView(withId(R.id.unit_input_first)).perform(
            typeText("-2")
        )
        onView(withId(R.id.unit_input_second)).check(
            matches(withText("-528.3440745683693"))
        )
    }

    @Test
    fun testTypingInSecondFiled() {
        onView(
            withId(R.id.unit_first_selector)
        ).perform(click())
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Cubic meter")
            )
        ).perform(click())
        onView(
            withId(R.id.unit_second_selector)
        ).perform(click())
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Litre")
            )
        ).perform(click())

        onView(withId(R.id.unit_input_second)).perform(
            typeText("10")
        )
        onView(withId(R.id.unit_input_first)).check(
            matches(withText("0.01"))
        )
    }
}