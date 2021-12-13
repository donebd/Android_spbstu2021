package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import com.example.lab3_2.databinding.ActivityMainBinding

class MainActivity : MyActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnToSecond.setOnClickListener {
            navToActivity2()
        }
    }

    private fun navToActivity2() {
        startActivity(Intent(this, Activity2::class.java))
    }

}