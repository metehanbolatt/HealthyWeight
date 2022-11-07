package com.metehanbolat.healthyweight.ui.login.sign_up.choose_weight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentChooseWeightBinding
import com.metehanbolat.healthyweight.ui.login.sign_up.SignUpNavGraphViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseWeightFragment: Fragment() {

    private var _binding: FragmentChooseWeightBinding? = null
    private val binding get() = _binding!!

    private val navViewModel: SignUpNavGraphViewModel by navGraphViewModels(R.id.sign_up_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseWeightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setWeightPicker()
        buttonClick()
    }

    private fun buttonClick() {
        binding.nextButton.setOnClickListener {
            navViewModel.setChosenWeight(binding.weightPicker.value)
            val action = ChooseWeightFragmentDirections.actionChooseWeightFragmentToChooseBirthdayFragment()
            findNavController().navigate(action)
        }
    }

    private fun setWeightPicker() {
        binding.weightPicker.apply {
            minValue = 10
            maxValue = 300
            value = 65
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}