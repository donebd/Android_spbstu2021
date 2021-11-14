package com.example.myapplication

import androidx.core.app.ActivityCompat.recreate
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecreateTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun launchMainActivity() {
        scenario = launchActivity()
    }

    @Test
    fun frag1() {
        assertOnScreen(fragment1)
        scenario.recreate()
        assertOnScreen(fragment1)
        assertOnScreen(toSecond)
    }

    @Test
    fun frag2() {
        click(toSecond)
        assertOnScreen(fragment2)
        scenario.recreate()
        assertOnScreen(fragment2)
        assertOnScreen(toThird)
        assertOnScreen(toFirst)
    }

    @Test
    fun frag3() {
        click(toSecond)
        click(toThird)
        assertOnScreen(fragment3)
        scenario.recreate()
        assertOnScreen(fragment3)
        assertOnScreen(toSecond)
        assertOnScreen(toFirst)
    }

}