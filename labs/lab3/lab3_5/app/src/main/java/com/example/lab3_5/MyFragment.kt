package com.example.lab3_5

import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding

open class MyFragment : Fragment() {

    protected var binding: ViewBinding? = null

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about_item) {
            Navigation.findNavController(binding!!.root).navigate(R.id.activityAbout)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}