package com.xpresscure.roomdatabse.LocalStorage.Others.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Entity(tableName = "userinfo")
data class UserData(
    @PrimaryKey(autoGenerate = false)
    val fullname: String, val Hobbies: List<HobbiesItem>){
    companion object{

        class HobbiesConverter{
            @TypeConverter
            fun hobbiesToJson(value:List<HobbiesItem>) = Json.encodeToString(value)

            @TypeConverter
            fun jsonToHobbies(value:String) = Json.decodeFromString<List<HobbiesItem>>(
                value
            )

        }

    }
}
@Serializable
data class HobbiesItem(val item:String)