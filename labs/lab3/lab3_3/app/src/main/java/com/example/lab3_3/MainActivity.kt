package com.example.lab3_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.lab3_3.databinding.ActivityMainBinding

class MainActivity : MyActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnToSecond.setOnClickListener {
            navToActivity2()
        }

        binding.buttonNoHistory.setOnClickListener {
            navToActivity2NoHistory()
        }
    }

    private fun navToActivity2() {
        startActivity(Intent(this, Activity2::class.java))
    }

    private fun navToActivity2NoHistory() {
        startActivity(Intent(this, Activity2::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY))
    }

}