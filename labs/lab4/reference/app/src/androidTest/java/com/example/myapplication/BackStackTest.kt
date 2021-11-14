package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackStackTest {

    @Before
    fun launchMainActivity() {
        launchActivity<MainActivity>()
    }

    @Test
    fun frag1BackStack() {
        openAbout()
        goBack()
        assertDestroyed(R.id.activity_about)
        openAbout()
        goBack()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag1BackStackV2() {
        openAbout()
        goUp()
        assertDestroyed(R.id.activity_about)
        openAbout()
        goUp()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag2BackStack() {
        openAbout()
        goBack()
        click(toSecond)
        openAbout()
        goBack()
        assertDestroyed(R.id.activity_about)
        goBack()
        assertDestroyed(fragment2)
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag2BackStackV2() {
        openAbout()
        goBack()
        click(toSecond)
        openAbout()
        goBack()
        click(toFirst)
        assertDestroyed(fragment2)
        openAbout()
        goBack()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag2BackStackV3() {
        openAbout()
        goUp()
        click(toSecond)
        openAbout()
        goUp()
        click(toFirst)
        openAbout()
        goUp()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag3BackStack() {
        openAbout()
        goBack()
        click(toSecond)
        openAbout()
        goBack()
        click(toThird)
        openAbout()
        goBack()
        assertDestroyed(R.id.activity_about)
        goBack()
        assertDestroyed(fragment3)
        openAbout()
        goBack()
        goBack()
        assertDestroyed(fragment2)
        openAbout()
        goBack()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag3BackStackV2() {
        openAbout()
        goUp()
        click(toSecond)
        openAbout()
        goUp()
        click(toThird)
        openAbout()
        goUp()
        assertDestroyed(R.id.activity_about)
        goUp()
        assertDestroyed(fragment3)
        openAbout()
        goUp()
        goUp()
        assertDestroyed(fragment2)
        openAbout()
        goUp()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag3BackStackV3() {
        openAbout()
        goBack()
        click(toSecond)
        openAbout()
        goBack()
        click(toThird)
        openAbout()
        goBack()
        click(toSecond)
        assertDestroyed(fragment3)
        openAbout()
        goBack()
        click(toFirst)
        assertDestroyed(fragment2)
        openAbout()
        goBack()
        assertDestroyed(R.id.activity_about)
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun frag3BackStackV4() {
        openAbout()
        goBack()
        click(toSecond)
        openAbout()
        goBack()
        click(toThird)
        openAbout()
        goBack()
        assertDestroyed(R.id.activity_about)
        click(toFirst)
        assertDestroyed(fragment3)
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun bogoTest() {
        openAbout()
        goBack()
        click(toSecond)
        click(toThird)
        click(toFirst)
        click(toSecond)
        click(toFirst)
        click(toSecond)
        click(toThird)
        click(toSecond)
        click(toThird)
        openAbout()
        goUp()
        goUp()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

    @Test
    fun bogoTestV2() {
        click(toSecond)
        click(toThird)
        click(toFirst)
        click(toSecond)
        click(toFirst)
        click(toSecond)
        click(toThird)
        click(toSecond)
        click(toThird)
        openAbout()
        goBack()
        goBack()
        goBack()
        assertDestroyed(R.id.activity_main)
    }

}