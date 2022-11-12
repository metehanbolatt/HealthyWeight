package com.metehanbolat.healthyweight.ui.login.sign_in

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.metehanbolat.domain.model.Member
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.FragmentSignInBinding
import com.metehanbolat.healthyweight.ui.main.home.HomeActivity
import com.metehanbolat.healthyweight.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private val activityViewModel: SignInActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.lostFocusList(
            listOf(binding.emailTextInputLayout, binding.passwordTextInputLayout), requireActivity()
        )

        buttonClickObserver()

        binding.enterButton.setOnClickListener {
            if (emptyFieldControl()) {
                val email = binding.emailText.text.toString()
                val password = binding.passwordText.text.toString()
                val member = Member(email = email, password = password)
                activityViewModel.signInMember(member)
            }
        }

        binding.signUpActionText.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpActivity()
            findNavController().navigate(action)
        }
    }

    private fun buttonClickObserver() {
        activityViewModel.signInMember.observe(viewLifecycleOwner) { memberState ->
            if (memberState.isLoading) {
                binding.loadingLottie.visible()
                viewVisibilityState(false)
                if (memberState.error.isNotBlank()) {
                    binding.loadingLottie.gone()
                    viewVisibilityState(true)
                } else {
                    binding.loadingLottie.gone()
                    Intent(requireActivity(), HomeActivity::class.java).apply {
                        startActivity(this)
                        requireActivity().finish()
                    }
                }
            }
        }
    }

    private fun viewVisibilityState(isVisible: Boolean) {
        binding.apply {
            if (isVisible) {
                appLogo.visible()
                appName.visible()
                emailTextInputLayout.visible()
                passwordTextInputLayout.visible()
                enterButton.visible()
                signUpInfoText.visible()
                signUpActionText.visible()
            } else {
                appLogo.gone()
                appName.gone()
                emailTextInputLayout.gone()
                passwordTextInputLayout.gone()
                enterButton.gone()
                signUpInfoText.gone()
                signUpActionText.gone()
            }
        }
    }

    private fun emptyFieldControl(): Boolean {
        val emailTextEmptyRule =
            binding.emailText.validateRule(R.string.error_text) { it.isNullOrEmpty() }
        val passwordTextEmptyRule =
            binding.passwordText.validateRule(R.string.error_text) { it.isNullOrEmpty() }
        return emailTextEmptyRule && passwordTextEmptyRule
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}