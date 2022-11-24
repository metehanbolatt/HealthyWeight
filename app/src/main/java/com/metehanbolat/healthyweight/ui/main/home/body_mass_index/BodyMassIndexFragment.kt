package com.metehanbolat.healthyweight.ui.main.home.body_mass_index

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.metehanbolat.healthyweight.databinding.FragmentBodyMassIndexBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BodyMassIndexFragment: Fragment() {

    private var _binding: FragmentBodyMassIndexBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBodyMassIndexBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}