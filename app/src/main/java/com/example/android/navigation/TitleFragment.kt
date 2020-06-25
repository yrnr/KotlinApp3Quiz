package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding
import java.util.*

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        this.setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
//        binding.playButton.setOnClickListener(){
//            view: View -> Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
//              view: View -> view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }

//        binding.playButton.setOnClickListener(
//            Navigation.createNavigateOnClickListener(
//                    R.id.action_titleFragment_to_gameFragment)  )

        binding.playButton.setOnClickListener { v: View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.about_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }

}