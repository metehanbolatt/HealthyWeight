package com.metehanbolat.healthyweight.ui.login.sign_up.choose_birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.metehanbolat.domain.model.BirthdayModel
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentChooseBirthdayBinding
import com.metehanbolat.healthyweight.ui.login.sign_up.SignUpNavGraphViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseBirthdayFragment : Fragment() {

    private var _binding: FragmentChooseBirthdayBinding? = null
    private val binding get() = _binding!!

    private val navGraphViewModel: SignUpNavGraphViewModel by navGraphViewModels(R.id.sign_up_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseBirthdayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.birthdayPicker.maxDate = System.currentTimeMillis()

        binding.nextButton.setOnClickListener {
            binding.birthdayPicker.apply {
                val birthday = BirthdayModel(
                    day = dayOfMonth.toString(),
                    month = (month + 1).toString(),
                    year = year.toString()
                )
                navGraphViewModel.setChosenBirthday(birthday)
            }
            val action = ChooseBirthdayFragmentDirections.actionChooseBirthdayFragmentToChoosePersonalInformationFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}