package com.xpresscure.roomdatabse.LocalStorage.RoomDi

import android.content.Context
import androidx.room.Room
import com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources.RoomDao
import com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources.RoomDatabaseInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvideRoomDb {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RoomDatabaseInstance {
        return Room.databaseBuilder(context, RoomDatabaseInstance::class.java, "users").build()
    }

    @Provides
    fun provideDao(roomDatabaseInstance: RoomDatabaseInstance): RoomDao {
        return roomDatabaseInstance.getDao()
    }
}