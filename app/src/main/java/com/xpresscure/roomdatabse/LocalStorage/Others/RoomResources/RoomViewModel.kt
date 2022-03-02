package com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.UserData
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RoomViewModel @Inject constructor(val roomRepo: RoomRepo) : ViewModel() {

    val usersList: LiveData<List<Users>> = roomRepo.getUserList()

    fun createUser(users: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepo.createUser(users)
        }
    }

    fun deleteCurrentUsers(users: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepo.updateCurrentUsers(users)
        }
    }

    fun updateCurrentUsers(users: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepo.updateCurrentUsers(users)

        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            roomRepo.deleteAllUsers()
        }
    }

    fun insertUserData(userData: UserData) {

        viewModelScope.launch {
            roomRepo.insertUserData(userData)
        }
    }

    val getUserData = roomRepo.getUserData()



}