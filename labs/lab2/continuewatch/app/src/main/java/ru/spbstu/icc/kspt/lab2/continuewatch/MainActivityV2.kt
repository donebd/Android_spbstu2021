package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivityV2 : AppCompatActivity() {

    private val SAVE_KEY = "Saved seconds"

    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    var onScreen = false
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sharedPref = getSharedPreferences(SAVE_KEY, Context.MODE_PRIVATE)
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
        with(sharedPref.edit()) {
            putInt(SAVE_KEY, secondsElapsed)
            apply()
        }
    }

    override fun onResume() {
        super.onResume()
        onScreen = true
        secondsElapsed = sharedPref.getInt(SAVE_KEY, 0)
    }
}
