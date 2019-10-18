package com.yamikrish.app.navigationDemo.ui.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.adapter.PostAdapter
import com.yamikrish.app.navigationDemo.model.Post
import kotlinx.android.synthetic.main.home_fragment.*

/* 
 * Created by Yamini on 16/5/18.
 */

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    lateinit var adapter : PostAdapter
    var data: List<Post> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userList.layoutManager = LinearLayoutManager(context)
        adapter = PostAdapter(context!!, data)
        userList.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.fetchAllData().observe(this, object: Observer<List<Post>> {
            override fun onChanged(t: List<Post>?) {
                Log.v("users","users=="+t)
                adapter.addItems(t)
            }

        })

    }

}
