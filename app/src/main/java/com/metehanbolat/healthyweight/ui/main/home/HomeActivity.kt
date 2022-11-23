package com.metehanbolat.healthyweight.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.ActivityHomeBinding
import com.metehanbolat.healthyweight.databinding.NavHeaderBinding
import com.metehanbolat.healthyweight.ui.login.sign_in.SignInActivity
import com.metehanbolat.healthyweight.util.safeNavigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navHeaderBinding: NavHeaderBinding

    private val viewModel: HomeActivityViewModel by viewModels()

    private lateinit var toggle: ActionBarDrawerToggle

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navHeaderBinding =
            NavHeaderBinding.inflate(LayoutInflater.from(binding.homeNavigationView.context))
        binding.homeNavigationView.addHeaderView(navHeaderBinding.root)

        toggle =
            ActionBarDrawerToggle(this, binding.homeDrawerLayout, R.string.open, R.string.close)
        binding.homeDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        observers()
        homeNavigationDrawerClicks()
        bottomNavigationClicks()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun observers() {
        viewModel.signOut.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            Intent(this, SignInActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }

    private fun homeNavigationDrawerClicks() {
        binding.homeNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bodyMassIndex -> {
                    navController.safeNavigate(R.id.bodyMassIndexFragment)
                    binding.homeDrawerLayout.close()
                }
                R.id.item2 -> {}
                R.id.item3 -> {}
                R.id.signOut -> {
                    viewModel.signOut()
                }
            }
            true
        }
    }

    private fun bottomNavigationClicks() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeMenuItem -> {
                    navController.safeNavigate(R.id.homeFragment)
                }
                R.id.profileMenuItem -> {
                    navController.safeNavigate(R.id.profileFragment)
                }
            }
            true
        }
    }

}
