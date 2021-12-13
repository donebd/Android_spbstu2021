package com.example.lab3_5

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.example.lab3_5.databinding.Fragment1Binding

class Fragment1 : MyFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = Fragment1Binding.inflate(inflater, container, false)
        with(binding as Fragment1Binding) {
            bnToSecond.setOnClickListener {
                findNavController().navigate(R.id.action_fragment1_to_fragment2)
            }
        }
        return binding!!.root
    }

}