package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import com.example.lab3_2.databinding.Activity3Binding

class Activity3 : MyActivity() {

    private lateinit var binding: Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnToFirst.setOnClickListener {
            navToActivity1()
        }

        binding.bnToSecond.setOnClickListener {
            navToActivity2()
        }

    }

    private fun navToActivity1() {
        val intent = Intent()
        intent.putExtra(EXTRA_INTERACT, REQUEST_TO_FIRST)
        setResult(1, intent)
        finish()
    }

    private fun navToActivity2() {
        finish()
    }

}