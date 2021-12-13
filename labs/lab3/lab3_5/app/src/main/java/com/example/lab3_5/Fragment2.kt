package com.example.lab3_5

import android.os.Bundle
import android.view.*

import androidx.navigation.fragment.findNavController
import com.example.lab3_5.databinding.Fragment2Binding

class Fragment2 : MyFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = Fragment2Binding.inflate(inflater, container, false)
        with(binding as Fragment2Binding) {
            bnToFirst.setOnClickListener {
                findNavController().navigate(R.id.action_fragment2_to_fragment1)
            }

            bnToThird.setOnClickListener {
                findNavController().navigate(R.id.action_fragment2_to_fragment3)
            }
        }
        return binding!!.root
    }

}