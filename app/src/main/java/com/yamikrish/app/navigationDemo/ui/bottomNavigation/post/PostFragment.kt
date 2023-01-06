package com.yamikrish.app.navigationDemo.ui.bottomNavigation.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.adapter.PostAdapter
import com.yamikrish.app.navigationDemo.databinding.PostFragmentBinding
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.ui.basic.post.PostFragment
import com.yamikrish.app.navigationDemo.ui.basic.post.PostViewModel

/* 
 * Created by Yamini on 16/5/18.
 */

class PostFragment : Fragment(R.layout.post_fragment) {

    companion object {
        fun newInstance() = PostFragment()
    }

    private lateinit var mBinding: PostFragmentBinding
    private val viewModel: PostViewModel by viewModels()
    lateinit var postAdapter: PostAdapter
    var data: List<Post> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = PostFragmentBinding.bind(view)

        context?.let {
            mBinding.userList.apply {
                layoutManager = LinearLayoutManager(it)
                postAdapter = PostAdapter(it, data)
                adapter = postAdapter
            }
        }


        viewModel.fetchAllData().observe(
            viewLifecycleOwner
        ) { t ->
            postAdapter.addItems(t)
        }

    }

}
