package com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.UserData
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import com.xpresscure.roomdatabse.LocalStorage.RoomDi.*


@Database(entities = [Users::class,UserData::class], version = 1, exportSchema = false)
@TypeConverters(UserData.Companion.HobbiesConverter::class)
abstract class RoomDatabaseInstance : RoomDatabase() {
    abstract fun getDao(): RoomDao

}