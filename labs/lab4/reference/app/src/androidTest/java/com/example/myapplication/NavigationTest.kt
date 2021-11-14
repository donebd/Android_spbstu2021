package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Before
    fun launchMainActivity() {
        launchActivity<MainActivity>()
    }

    @Test
    fun testFrag12() {
        assertOnScreen(fragment1)
        click(toSecond)
        assertOnScreen(fragment2)
    }

    @Test
    fun testFrag1About() {
        openAbout()
        assertOnScreen(R.id.activity_about)
        goUp()
        assertOnScreen(fragment1)

        openAbout()
        goBack()
        assertOnScreen(fragment1)
    }


    @Test
    fun testFrag21() {
        click(toSecond)
        click(toFirst)
        assertOnScreen(fragment1)

        click(toSecond)
        goUp()
        assertOnScreen(fragment1)

        click(toSecond)
        goBack()
        assertOnScreen(fragment1)
    }

    @Test
    fun testFrag23() {
        click(toSecond)
        click(toThird)
        assertOnScreen(fragment3)
    }

    @Test
    fun testFrag2About() {
        click(toSecond)
        openAbout()
        assertOnScreen(R.id.activity_about)
        goUp()
        assertOnScreen(fragment2)
    }

    @Test
    fun testFrag32() {
        click(toSecond)
        click(toThird)
        click(toSecond)
        assertOnScreen(fragment2)

        click(toThird)
        goUp()
        assertOnScreen(fragment2)

        click(toThird)
        goBack()
        assertOnScreen(fragment2)
    }

    @Test
    fun testFrag31() {
        click(toSecond)
        click(toThird)
        click(toSecond)
        click(toFirst)
        assertOnScreen(fragment1)

        click(toSecond)
        click(toThird)
        goUp()
        goUp()
        assertOnScreen(fragment1)

        click(toSecond)
        click(toThird)
        goBack()
        goBack()
        assertOnScreen(fragment1)
    }

    @Test
    fun testFrag3About() {
        click(toSecond)
        click(toThird)
        openAbout()
        assertOnScreen(R.id.activity_about)

        goUp()
        assertOnScreen(fragment3)

        openAbout()
        goBack()
        assertOnScreen(fragment3)
    }

    @Test
    fun conformityText() {
        assertButtonText(toSecond, R.string.title_to_second)
        click(toSecond)
        assertButtonText(toFirst, R.string.title_to_first)
        assertButtonText(toThird, R.string.title_to_third)
        click(toThird)
        assertButtonText(toSecond, R.string.title_to_second)
        assertButtonText(toFirst, R.string.title_to_first)
    }

}
