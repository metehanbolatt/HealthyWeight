package com.metehanbolat.healthyweight.ui.login.sign_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.metehanbolat.healthyweight.databinding.ActivitySignInBinding
import com.metehanbolat.healthyweight.ui.main.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity(){

    private lateinit var binding: ActivitySignInBinding

    private val viewModel: SignInActivityViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        currentUserObserver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    private fun currentUserObserver() {
        viewModel.currentUser.observe(this) {
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}