package ru.spbstu.icc.kspt.lab6.continuewatch

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class CoroutineRealization : AppCompatActivity() {

    private val MY_LOG = this.javaClass.name
    private val SAVE_KEY = "Key"

    private var secondsElapsed: Double = 0.0
    private lateinit var textSecondsElapsed: TextView
    private var startTime: Long = 0
    private var currentTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        val a = lifecycleScope.launchWhenResumed {
            Log.i(MY_LOG, "$this is started")
            while (isActive) {
                Log.i(MY_LOG, "Coroutine works")
                delay(1000)
                updateTime()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        startTime = System.currentTimeMillis()
    }

    private fun updateTime() {
        currentTime = System.currentTimeMillis()
        secondsElapsed += (currentTime - startTime) / 1000.0
        startTime = currentTime
        Log.i(MY_LOG, "$secondsElapsed")

        MainScope().launch {
            textSecondsElapsed.text = resources.getQuantityString(
                R.plurals.secCounter,
                secondsElapsed.toInt(),
                secondsElapsed.toInt()
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putDouble(SAVE_KEY, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getDouble(SAVE_KEY)
        }
    }
}
