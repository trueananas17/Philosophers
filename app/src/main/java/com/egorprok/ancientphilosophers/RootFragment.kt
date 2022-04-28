package com.egorprok.ancientphilosophers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.egorprok.ancientphilosophers.databinding.FragmentRootBinding

class RootFragment: Fragment(R.layout.fragment_root) {
    private lateinit var  binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)
        binding.vityaBtn.setOnClickListener { findNavController().navigate(R.id.action_rootFragment_to_vityaFragment)}
        binding.volodyaBtn.setOnClickListener { findNavController().navigate(R.id.action_rootFragment_to_volodyaFragment) }
    }
}