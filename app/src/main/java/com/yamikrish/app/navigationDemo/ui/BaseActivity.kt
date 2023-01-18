package com.yamikrish.app.navigationDemo.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.databinding.ActivityBaseBinding
import com.yamikrish.app.navigationDemo.ui.basic.BasicMainActivity
import com.yamikrish.app.navigationDemo.ui.bottomNavigation.BottomNavigationActivity

class BaseActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.basicsButton.setOnClickListener(this)
        mBinding.bottomNavButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v){
            mBinding.basicsButton -> startActivity(Intent(this, BasicMainActivity::class.java))

            mBinding.bottomNavButton -> startActivity(Intent(this, BottomNavigationActivity::class.java))

        }
    }
}