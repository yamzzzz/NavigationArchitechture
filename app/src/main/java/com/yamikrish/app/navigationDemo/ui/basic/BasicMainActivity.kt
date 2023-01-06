package com.yamikrish.app.navigationDemo.ui.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.databinding.ActivityBasicMainBinding
import com.yamikrish.app.navigationDemo.databinding.ActivityBottomBaseBinding

class BasicMainActivity: AppCompatActivity() {

    private lateinit var mBinding: ActivityBasicMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBasicMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.container).navigateUp()
    }
}