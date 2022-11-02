package com.metehanbolat.healthyweight.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.metehanbolat.healthyweight.databinding.ActivityHomeBinding
import com.metehanbolat.healthyweight.ui.login.sign_in.SignInActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.exitButton.setOnClickListener {
            viewModel.signOut()
        }

        viewModel.signOut.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            Intent(this, SignInActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }

    }
}