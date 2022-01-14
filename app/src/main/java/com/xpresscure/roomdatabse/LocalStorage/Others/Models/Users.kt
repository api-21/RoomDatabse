package com.xpresscure.roomdatabse.LocalStorage.Others.Models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_details")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val village: String
):Parcelable
