package com.yamikrish.app.navigationDemo.ui.bottomNavigation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yamikrish.app.navigationDemo.model.User
import com.yamikrish.app.navigationDemo.repository.APIService

/* 
 * Created by Yamini on 15/5/18.
 */

class ProfileViewModel : ViewModel() {
    fun fetchUser(): LiveData<User> = APIService.getUser()
}