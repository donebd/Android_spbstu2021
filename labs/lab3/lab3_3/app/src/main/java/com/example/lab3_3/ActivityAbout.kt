package com.example.lab3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3_3.databinding.ActivityAboutBinding

class ActivityAbout : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}