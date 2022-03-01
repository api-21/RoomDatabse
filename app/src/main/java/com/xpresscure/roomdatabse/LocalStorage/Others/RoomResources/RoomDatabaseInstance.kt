package com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import com.xpresscure.roomdatabse.LocalStorage.RoomDi.*


@Database(entities = [Users::class, ConsultationCollection::class], version = 1, exportSchema = false)
@TypeConverters(
    ConsultationConverter::class,
    DoctorChatConverter::class,
    CallLogsConverter::class,
    FollowUpConverter::class
)
abstract class RoomDatabaseInstance : RoomDatabase() {
    abstract fun getDao(): RoomDao

}