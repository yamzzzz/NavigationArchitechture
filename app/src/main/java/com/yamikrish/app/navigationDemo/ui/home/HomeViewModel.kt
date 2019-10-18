package com.yamikrish.app.navigationDemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yamikrish.app.navigationDemo.model.Post
import com.yamikrish.app.navigationDemo.repository.APIService

/* 
 * Created by Yamini on 16/5/18.
 */

class HomeViewModel : ViewModel() {
    var list: LiveData<List<Post>>

    init {
        list =  APIService.getUserList()
    }

    fun fetchAllData() : LiveData<List<Post>> = list
}