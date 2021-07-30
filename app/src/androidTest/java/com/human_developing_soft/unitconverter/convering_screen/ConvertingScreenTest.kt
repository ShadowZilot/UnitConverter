package com.human_developing_soft.unitconverter.convering_screen

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.human_developing_soft.unitconverter.ui.converting.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConvertingScreenTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
}