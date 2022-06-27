package com.sumeyye.sm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.sumeyye.sm.databinding.ActivityMainBinding
import com.sumeyye.sm.databinding.FragmentLoginBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.homeFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            } else if (destination.id==R.id.bagFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }else if (destination.id==R.id.favoritesFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }else if (destination.id==R.id.profileFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }else if (destination.id==R.id.shopFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
            else {
                binding.bottomNavigation.visibility = View.GONE
            }
        }
    }

}