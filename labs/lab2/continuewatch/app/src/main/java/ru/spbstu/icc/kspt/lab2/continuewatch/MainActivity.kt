package ru.spbstu.icc.kspt.lab2.continuewatch

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val SAVE_KEY = "Saved seconds"

    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    var onScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        backgroundThread.start()
    }

    var backgroundThread = Thread {
        while (true) {
            textSecondsElapsed.post {
                if (onScreen) {
                    textSecondsElapsed.text = resources.getQuantityString(
                        R.plurals.secCounter,
                        secondsElapsed,
                        secondsElapsed
                    )
                    secondsElapsed++
                }
            }
            Thread.sleep(1000)
        }
    }

    override fun onPause() {
        super.onPause()
        onScreen = false
    }

    override fun onResume() {
        super.onResume()
        onScreen = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt(SAVE_KEY, secondsElapsed)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getInt(SAVE_KEY)
        }
    }
}
