package com.yamikrish.app.navigationDemo.ui.bottomNavigation.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.repository.APIService

/* 
 * Created by Yamini on 16/5/18.
 */

class PostViewModel : ViewModel() {
    fun fetchAllData(): LiveData<List<Post>> = APIService.getPostList()
}