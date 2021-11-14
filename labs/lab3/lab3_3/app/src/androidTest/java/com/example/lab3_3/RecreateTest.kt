package com.example.lab3_3

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

    private fun ActivityScenario<MainActivity>.rotate() {
        this.onActivity {
            it.apply {
                requestedOrientation = (requestedOrientation + 1) % 2
            }
        }
    }

    @Test
    fun frag1() {
        assertOnScreen(fragment1)
        scenario.rotate()
        assertOnScreen(fragment1)
        assertOnScreen(toSecond)
    }

    @Test
    fun frag2() {
        click(toSecond)
        assertOnScreen(fragment2)
        scenario.rotate()
        assertOnScreen(fragment2)
        assertOnScreen(toThird)
        assertOnScreen(toFirst)
    }

    @Test
    fun frag3() {
        click(toSecond)
        click(toThird)
        assertOnScreen(fragment3)
        scenario.rotate()
        assertOnScreen(fragment3)
        assertOnScreen(toSecond)
        assertOnScreen(toFirst)
    }

}