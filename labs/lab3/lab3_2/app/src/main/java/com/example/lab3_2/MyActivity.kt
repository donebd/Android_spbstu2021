package com.example.lab3_2

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class MyActivity : AppCompatActivity() {

    protected val REQUEST_TO_THIRD = 226
    protected val REQUEST_TO_SECOND = 227
    protected val REQUEST_TO_FIRST = 228
    protected val EXTRA_INTERACT = "action_code"

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