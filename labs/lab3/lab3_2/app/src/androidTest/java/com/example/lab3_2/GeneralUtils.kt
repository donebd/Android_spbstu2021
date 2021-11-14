package com.example.lab3_2

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Assert

const val toFirst = R.id.bnToFirst
const val toSecond = R.id.bnToSecond
const val toThird = R.id.bnToThird
const val fragment1 = R.id.activity_main
const val fragment2 = R.id.activity_2
const val fragment3 = R.id.activity_3

fun click(res: Int) {
    Espresso.onView(ViewMatchers.withId(res))
        .perform(ViewActions.click())
}

fun assertOnScreen(res: Int) {
    Espresso.onView(ViewMatchers.withId(res))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}

fun assertDestroyed(res: Int) {
    ViewMatchers.withId(res).matches(null)
}

fun assertButtonText(btn: Int, text: Int) {
    Espresso.onView(ViewMatchers.withText(text))
        .check { view, _ ->
            Assert.assertTrue(view.id == btn)
        }
}

fun goUp(){
    Espresso.onView(ViewMatchers.withContentDescription(R.string.nav_app_bar_navigate_up_description))
        .perform(ViewActions.click())
}

fun goBack(){
    pressBackUnconditionally()
}
