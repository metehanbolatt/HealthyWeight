package com.metehanbolat.healthyweight.ui.login.sign_up.chooseheight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentChooseHeightBinding
import com.metehanbolat.healthyweight.ui.login.sign_up.SignUpNavGraphViewModel
import com.metehanbolat.healthyweight.ui.login.sign_up.choosegender.model.Gender
import com.metehanbolat.healthyweight.util.setImageDrawableWithContextCompat
import com.metehanbolat.healthyweight.util.setImageTintListWithContextCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseHeightFragment : Fragment() {

    private var _binding: FragmentChooseHeightBinding? = null
    private val binding get() = _binding!!

    private val navViewModel: SignUpNavGraphViewModel by navGraphViewModels(R.id.sign_up_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseHeightBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.humanImage.apply {
            when(navViewModel.chosenGender.value) {
                Gender.FEMALE.gender -> {
                    setImageDrawableWithContextCompat(R.drawable.gender_female)
                    setImageTintListWithContextCompat(R.color.gender_female_color)
                }
                Gender.MALE.gender -> {
                    setImageDrawableWithContextCompat(R.drawable.gender_male)
                    setImageTintListWithContextCompat(R.color.gender_male_color)
                }
            }
        }

        binding.heightPicker.minValue = 120
        binding.heightPicker.maxValue = 250

        binding.heightPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            binding.humanImage.layoutParams.height = newVal * 3
            binding.humanImage.requestLayout()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
