package com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources

import androidx.lifecycle.LiveData
import androidx.room.*
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import com.xpresscure.roomdatabse.LocalStorage.RoomDi.ConsultationCollection

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(users: Users)

    @Query("SELECT * FROM user_details ORDER BY id ASC")
    fun getAllUsers():LiveData<List<Users>>

    @Update
    suspend fun updateUsers(users: Users)

    @Delete
    suspend fun deleteUsers(users: Users)

    @Query("DELETE FROM user_details")
    suspend fun deleteAllUsers()

    @Insert
    suspend fun insertConsult(consultation : ConsultationCollection)

}