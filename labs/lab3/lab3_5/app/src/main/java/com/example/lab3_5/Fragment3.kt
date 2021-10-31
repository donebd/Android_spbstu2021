package com.example.lab3_5
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lab3_5.databinding.Fragment3Binding

class Fragment3: Fragment() {

    private var binding: Fragment3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = Fragment3Binding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding!!) {
            btnToFirst.setOnClickListener {
                findNavController().navigate(R.id.action_fragment3_to_fragment1)
            }

            btnToSecond.setOnClickListener {
                findNavController().navigate(R.id.action_fragment3_to_fragment2)
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