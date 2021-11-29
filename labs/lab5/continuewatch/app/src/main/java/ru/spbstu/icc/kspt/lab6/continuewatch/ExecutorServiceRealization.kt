package ru.spbstu.icc.kspt.lab6.continuewatch

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ExecutorServiceRealization : AppCompatActivity() {

    private val MY_LOG = this.javaClass.name
    private val SAVE_KEY = "Key"

    private var secondsElapsed: Double = 0.0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var executorService: ExecutorService
    private var startTime: Long = 0
    private var currentTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        executorService = Executors.newSingleThreadExecutor()
        executorService.execute(getThread())
        Log.i(MY_LOG, "$executorService is started")
        startTime = System.currentTimeMillis()
    }

    override fun onStop() {
        executorService.shutdown()
        super.onStop()
    }

    private fun getThread(): Thread = Thread {
        while (!executorService.isShutdown) {
            Thread.sleep(1000)
            Log.i(MY_LOG, "${Thread.currentThread()} iterating")
            updateTime()
        }
        Log.i(MY_LOG, "${Thread.currentThread()} is stopped")
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
