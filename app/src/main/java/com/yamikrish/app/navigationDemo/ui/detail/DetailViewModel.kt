package com.yamikrish.app.navigationDemo.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.repository.APIService

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailViewModel(id: Int) : ViewModel() {
    var post: LiveData<Post>

    init {
        post =  APIService.getPostById(id)
    }

    fun fetchPostById() : LiveData<Post> = post
}
