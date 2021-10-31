package com.example.lab3_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.lab3_5.databinding.Activity1Binding

class Activity1 : AppCompatActivity() {
    private lateinit var binding: Activity1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about_item) {
            startActivity(Intent(this, ActivityAbout::class.java))
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}