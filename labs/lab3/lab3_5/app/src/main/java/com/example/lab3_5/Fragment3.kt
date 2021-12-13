package com.example.lab3_5

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.example.lab3_5.databinding.Fragment3Binding

class Fragment3 : MyFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = Fragment3Binding.inflate(inflater, container, false)
        with(binding as Fragment3Binding) {
            bnToFirst.setOnClickListener {
                findNavController().navigate(R.id.action_fragment3_to_fragment1)
            }

            bnToSecond.setOnClickListener {
                findNavController().navigate(R.id.action_fragment3_to_fragment2)
            }
        }
        return binding!!.root
    }

}