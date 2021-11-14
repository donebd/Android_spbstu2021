package com.example.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.example.lab3_2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    private val REQUEST_TO_THIRD = 226
    private val REQUEST_TO_SECOND = 227
    private val REQUEST_TO_FIRST = 228

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
        if (requestCode == REQUEST_TO_THIRD && resultCode == REQUEST_TO_FIRST) {
            navToActivity1()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun navToActivity1() {
        finish()
    }

    private fun navToActivity3() {
        startActivityForResult(
            Intent(this, Activity3::class.java), REQUEST_TO_THIRD
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }
//code from activity1
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about_item) {
            startActivity(Intent(this, ActivityAbout::class.java))
            true
        } else
            super.onOptionsItemSelected(item)
    }
}