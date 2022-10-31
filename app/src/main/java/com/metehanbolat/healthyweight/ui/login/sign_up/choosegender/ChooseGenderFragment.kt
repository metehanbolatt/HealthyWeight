package com.metehanbolat.healthyweight.ui.login.sign_up.choosegender

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentChooseGenderBinding
import com.metehanbolat.healthyweight.ui.login.sign_up.SignUpNavGraphViewModel
import com.metehanbolat.healthyweight.ui.login.sign_up.choosegender.model.ChosenGenderInstance
import com.metehanbolat.healthyweight.util.setImageTintListWithContextCompat
import com.metehanbolat.healthyweight.util.setTextColorWithContextCompat
import com.metehanbolat.healthyweight.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseGenderFragment : Fragment() {

    private var _binding: FragmentChooseGenderBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ChooseGenderFragmentViewModel by viewModels()
    private val navViewModel: SignUpNavGraphViewModel by navGraphViewModels(R.id.sign_up_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseGenderBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelObservers()
        navViewModelObservers()

        binding.genderMale.setOnClickListener {
            viewModel.chosenMale()
        }

        binding.genderFemale.setOnClickListener {
            viewModel.chosenFemale()
        }

        binding.nextButton.setOnClickListener {
            val action = ChooseGenderFragmentDirections.actionChooseGenderFragmentToChooseHeightFragment()
            findNavController().navigate(action)
        }

    }

    private fun viewModelObservers() {
        viewModel.chosenMale.observe(viewLifecycleOwner) {
            val genderInstance = ChosenGenderInstance(
                genderMaleColor = it.genderMaleColor,
                genderFemaleColor = it.genderFemaleColor,
                selectedGenderText = it.selectedGenderText,
                selectedGenderTextColor = it.selectedGenderTextColor
            )
            genderImage(genderInstance = genderInstance)
        }

        viewModel.chosenFemale.observe(viewLifecycleOwner) {
            val genderInstance = ChosenGenderInstance(
                genderMaleColor = it.genderMaleColor,
                genderFemaleColor = it.genderFemaleColor,
                selectedGenderText = it.selectedGenderText,
                selectedGenderTextColor = it.selectedGenderTextColor
            )
            genderImage(genderInstance = genderInstance)
        }

    }

    private fun navViewModelObservers() {
        navViewModel.chosenGender.observe(viewLifecycleOwner) {
            binding.nextButton.visible()
        }
    }

    private fun genderImage(genderInstance: ChosenGenderInstance) {
        binding.apply {
            genderMale.setImageTintListWithContextCompat(genderInstance.genderMaleColor)
            genderFemale.setImageTintListWithContextCompat(genderInstance.genderFemaleColor)
            chosenGenderText.setTextColorWithContextCompat(genderInstance.selectedGenderTextColor)
            chosenGenderText.text = genderInstance.selectedGenderText
        }
        navViewModel.setChosenGender(genderInstance.selectedGenderText)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}