package com.metehanbolat.healthyweight.ui.main.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentHomeBinding
import com.metehanbolat.healthyweight.ui.main.home.HomeActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val navViewModel: HomeActivityViewModel by navGraphViewModels(R.id.home_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("Home Fragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}