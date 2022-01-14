package com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users


@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class RoomDatabaseInstance : RoomDatabase() {
    abstract fun getDao(): RoomDao

}