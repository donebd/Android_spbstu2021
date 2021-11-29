package ru.spbstu.icc.kspt.lab6.continuewatch

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThreadRealization : AppCompatActivity() {

    private val MY_LOG = this.javaClass.name
    private val SAVE_KEY = "Key"

    private var secondsElapsed: Double = 0.0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var backgroundThread: Thread
    private var startTime: Long = 0
    private var currentTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        backgroundThread = getThread()
        backgroundThread.start()
        Log.i(MY_LOG, "$backgroundThread is started")
        startTime = System.currentTimeMillis()
    }

    override fun onStop() {
        super.onStop()
        updateTime()
        backgroundThread.interrupt()
    }

    private fun getThread(): Thread = Thread {
        while (!Thread.currentThread().isInterrupted) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                Log.i(MY_LOG, "${Thread.currentThread()} is stopped")
                return@Thread
            }
            Log.i(MY_LOG, "${Thread.currentThread()} iterating")
            updateTime()
        }
    }

    private fun updateTime() {
        currentTime = System.currentTimeMillis()
        secondsElapsed += (currentTime - startTime) / 1000.0
        startTime = currentTime
        Log.i(MY_LOG, "$secondsElapsed")

        textSecondsElapsed.post {
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

