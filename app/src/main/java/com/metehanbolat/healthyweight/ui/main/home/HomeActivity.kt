package com.metehanbolat.healthyweight.ui.main.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.databinding.ActivityHomeBinding
import com.metehanbolat.healthyweight.databinding.NavHeaderBinding
import com.metehanbolat.healthyweight.ui.login.sign_in.SignInActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navHeaderBinding: NavHeaderBinding

    private val viewModel: HomeActivityViewModel by viewModels()

    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navHeaderBinding = NavHeaderBinding.inflate(LayoutInflater.from(binding.homeNavigationView.context))
        binding.homeNavigationView.addHeaderView(navHeaderBinding.root)

        toogle = ActionBarDrawerToggle(this, binding.homeDrawerLayout, R.string.open, R.string.close)
        binding.homeDrawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navHeaderBinding.nameText.setOnClickListener {
            println("name text tıklandı")
        }

        binding.homeNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bodyMassIndex -> {
                    println("Item1")
                    binding.homeDrawerLayout.closeDrawers()
                }
                R.id.item2 -> println("Item2")
                R.id.item3 -> println("Item3")
                R.id.signOut -> {
                    viewModel.signOut
                }
            }
            true
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        viewModel.signOut.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
            Intent(this, SignInActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}