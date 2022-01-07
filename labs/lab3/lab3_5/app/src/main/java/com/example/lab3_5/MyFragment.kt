package com.example.lab3_5

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class MyFragment : Fragment() {

    protected var binding: ViewBinding? = null

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}