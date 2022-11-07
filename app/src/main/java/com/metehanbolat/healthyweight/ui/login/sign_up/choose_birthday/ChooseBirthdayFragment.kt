package com.metehanbolat.healthyweight.ui.login.sign_up.choose_birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.metehanbolat.healthyweight.databinding.FragmentChooseBirthdayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseBirthdayFragment: Fragment() {

    private var _binding: FragmentChooseBirthdayBinding? = null
    private val binding get() = _binding!!

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}