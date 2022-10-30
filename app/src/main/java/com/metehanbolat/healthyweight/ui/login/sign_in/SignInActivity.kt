package com.metehanbolat.healthyweight.ui.login.sign_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.metehanbolat.healthyweight.databinding.ActivitySignInBinding
import com.metehanbolat.healthyweight.ui.login.sign_up.SignUpActivity
import com.metehanbolat.healthyweight.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val viewModel: SignInActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.enterButton.setOnClickListener {
            Intent(this, SignUpActivity::class.java).apply {
                startActivity(this)
            }
            /*
            val member = Member(
                email = binding.emailText.text.toString(),
                password = binding.passwordText.text.toString()
            )
            viewModel.signUpMember(member)

             */
        }

        viewModel.signUpMember.observe(this) { memberState ->
            when(memberState) {
                is UiState.Loading -> {
                    println("Loading")
                }
                is UiState.Success -> {
                    println(memberState.data)
                }
                is UiState.Failure -> {
                    println(memberState.error)
                }
            }
        }
    }
}