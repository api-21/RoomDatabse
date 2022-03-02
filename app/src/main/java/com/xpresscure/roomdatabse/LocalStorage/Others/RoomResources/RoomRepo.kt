package com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources

import com.xpresscure.roomdatabse.LocalStorage.Others.Models.UserData
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import javax.inject.Inject

class RoomRepo @Inject constructor(val roomDao: RoomDao) {

    fun getUserList() = roomDao.getAllUsers()

    suspend fun createUser(users: Users) = roomDao.createUser(users)

    suspend fun deleteAllUsers() = roomDao.deleteAllUsers()

    suspend fun deleteCurrentUser(users: Users) = roomDao.deleteUsers(users)

    suspend fun updateCurrentUsers(users: Users) = roomDao.updateUsers(users)

    suspend fun insertUserData(userData: UserData) = roomDao.insertUserInfo(userData)

     fun getUserData() = roomDao.getUserInfo()


}