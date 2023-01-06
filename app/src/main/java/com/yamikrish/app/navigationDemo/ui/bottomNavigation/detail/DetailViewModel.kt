package com.yamikrish.app.navigationDemo.ui.bottomNavigation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.repository.APIService

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailViewModel() : ViewModel() {
    fun fetchPostById(id: Int): LiveData<Post> = APIService.getPostById(id)
}
