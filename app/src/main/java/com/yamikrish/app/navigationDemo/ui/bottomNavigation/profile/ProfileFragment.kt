package com.yamikrish.app.navigationDemo.ui.bottomNavigation.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.databinding.DetailPageBinding
import com.yamikrish.app.navigationDemo.databinding.ProfileFragmentBinding
import com.yamikrish.app.navigationDemo.model.User

/* 
 * Created by Yamini on 15/5/18.
 */

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var mBinding: ProfileFragmentBinding
    lateinit var data: User


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = ProfileFragmentBinding.bind(view)
        viewModel.fetchUser().observe(
            viewLifecycleOwner
        ) { t ->
            Log.v("users", "users==" + t)
            setDataOnUI(t)
        }


    }

    private fun setDataOnUI(user: User?) {
        user?.let {
            mBinding.name.text = it.name
            mBinding.email.text = it.email
            mBinding.phone.text = it.phone
            mBinding.address.text = it.address.suite + ", " + it.address.street + ", " +
                    it.address.city + " - " + it.address.zipcode
        }

    }

}
