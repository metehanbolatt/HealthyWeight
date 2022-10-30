package com.metehanbolat.healthyweight.ui.login.sign_up.choosegender

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentChooseGenderBinding
import com.metehanbolat.healthyweight.ui.login.sign_up.SignUpNavGraphViewModel
import com.metehanbolat.healthyweight.util.setImageWithContextCompat
import com.metehanbolat.healthyweight.util.setTextColorWithContextCompat
import com.metehanbolat.healthyweight.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseGenderFragment : Fragment() {

    private var _binding: FragmentChooseGenderBinding? = null
    private val binding get() = _binding!!

    private val navViewModel: SignUpNavGraphViewModel by navGraphViewModels(R.id.sign_up_graph)

    private var genderManSelectedControl = false
    private var genderWomanSelectedControl = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseGenderBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navViewModel.chosenGender.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.nextButton.visible()
            }
        }

        binding.genderMan.setOnClickListener {
            genderManSelectedControl = !genderManSelectedControl
            if (genderManSelectedControl) {
                navViewModel.setChosenGender(Gender.MALE.gender)
                genderWomanSelectedControl = false
                binding.genderMan.setImageWithContextCompat(R.drawable.selected_man)
                binding.genderWoman.setImageWithContextCompat(R.drawable.unselected_woman)
                binding.chosenGenderText.setTextColorWithContextCompat(R.color.gender_male_color)
                binding.chosenGenderText.text = Gender.MALE.gender
            }
        }

        binding.genderWoman.setOnClickListener {
            genderWomanSelectedControl = !genderWomanSelectedControl
            if (genderWomanSelectedControl) {
                navViewModel.setChosenGender(Gender.FEMALE.gender)
                genderManSelectedControl = false
                binding.genderMan.setImageWithContextCompat(R.drawable.unselected_man)
                binding.genderWoman.setImageWithContextCompat(R.drawable.selected_woman)
                binding.chosenGenderText.setTextColorWithContextCompat(R.color.gender_female_color)
                binding.chosenGenderText.text = Gender.FEMALE.gender
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

enum class Gender(val gender: String) {
    MALE("Male"),
    FEMALE("Female")
}