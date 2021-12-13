package com.example.lab3_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.lab3_3.databinding.Activity2Binding

class Activity2 : MyActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnToFirst.setOnClickListener {
            navToActivity1()
        }

        binding.bnToThird.setOnClickListener {
            navToActivity3()
        }

    }

    private fun navToActivity1() {
        finish()
    }

    private fun navToActivity3() {
        startActivity(Intent(this, Activity3::class.java))
    }
}