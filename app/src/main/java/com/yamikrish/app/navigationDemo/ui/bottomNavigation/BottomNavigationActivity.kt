package com.yamikrish.app.navigationDemo.ui.bottomNavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.databinding.ActivityBottomBaseBinding

class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityBottomBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBottomBaseBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment?
        navHostFragment?.let {
            NavigationUI.setupWithNavController(mBinding.bottomTab, it.navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onNavigateUp()
    }

}
