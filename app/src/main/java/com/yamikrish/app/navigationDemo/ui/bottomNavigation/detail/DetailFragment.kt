package com.yamikrish.app.navigationDemo.ui.bottomNavigation.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.databinding.DetailPageBinding
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.ui.basic.detail.DetailFragmentArgs

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailFragment : Fragment(R.layout.detail_page) {
    private lateinit var mBinding: DetailPageBinding
    private var mId = 0
    private val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = DetailViewModel() as T
    }

    private val mViewModel: DetailViewModel by viewModels { factory }
    lateinit var post: Post

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = DetailPageBinding.bind(view)
        arguments?.let {
            mId = DetailFragmentArgs.fromBundle(it).id
        }


        mViewModel.fetchPostById(mId).observe(
            viewLifecycleOwner
        ) { t ->
            mBinding.postTitle.text = t?.title
            mBinding.description.text = t?.body
        }
    }
}
