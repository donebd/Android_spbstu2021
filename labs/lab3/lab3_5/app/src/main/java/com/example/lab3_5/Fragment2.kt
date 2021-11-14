package com.example.lab3_5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lab3_5.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private var binding: Fragment2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = Fragment2Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding!!) {
            bnToFirst.setOnClickListener {
                findNavController().navigate(R.id.action_fragment2_to_fragment1)
            }

            bnToThird.setOnClickListener {
                findNavController().navigate(R.id.action_fragment2_to_fragment3)
            }
        }
    }

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
        } else
            super.onOptionsItemSelected(item)
    }

}