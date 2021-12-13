package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import com.example.lab3_2.databinding.Activity2Binding

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("request code = $requestCode, result code = $resultCode")
        if (requestCode == REQUEST_TO_THIRD && data?.getIntExtra(EXTRA_INTERACT, 0) == REQUEST_TO_FIRST) {
            navToActivity1()
        }
    }

    private fun navToActivity1() {
        finish()
    }

    private fun navToActivity3() {
        startActivityForResult(
            Intent(this, Activity3::class.java), REQUEST_TO_THIRD
        )
    }
}