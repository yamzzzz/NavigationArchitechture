package com.yamikrish.app.navigationDemo.ui.detail

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.model.Post
import kotlinx.android.synthetic.main.detail_page.*

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)
        val id = DetailActivityArgs.fromBundle(intent.extras!!).id
        val factory = CustomViewModelFactory(id)


        supportActionBar?.let {
            it.title = getString(R.string.post_detail)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)

        viewModel.fetchPostById().observe(this, object : Observer<Post> {
            override fun onChanged(t: Post?) {
                postTitle.text = t?.title
                description.text = t?.body
            }

        })
    }

    class CustomViewModelFactory(private val test: Int) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DetailViewModel(test) as T
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return  true;
    }
}
