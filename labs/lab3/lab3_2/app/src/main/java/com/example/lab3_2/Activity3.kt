package com.example.lab3_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.lab3_2.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    private val REQUEST_TO_SECOND = 227
    private val REQUEST_TO_FIRST = 228

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
        setResult(REQUEST_TO_FIRST)
        finish()
    }

    private fun navToActivity2() {
        setResult(REQUEST_TO_SECOND)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about_item) {
            startActivity(Intent(this, ActivityAbout::class.java))
            true
        } else
            super.onOptionsItemSelected(item)
    }
}