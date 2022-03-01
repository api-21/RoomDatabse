package com.xpresscure.roomdatabse.LocalStorage.RoomDi

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity(tableName = "consultation")
data class ConsultationCollection(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val listOfConsultation: ArrayList<ConsultationData>
)

data class ConsultationData(
    val _id: String,
    val user_id: String,
    val doctor_id: String,
    val patient_name: String,
    val patient_img: String,
    val algoStatus: String,
    val consultStatus: String,
    val status: String,
    val booked_time: String,
    val freefollowup: String,
    val patient_fees: String,
    val patientstatus: String,
    val answeredCount: Int,
    val jiaAnsweredCount: Int,
    val appType: String,
    val doctorChat: ArrayList<DoctorChatArray>,
    val followUp: ArrayList<FollowUpArray>,
    val callLog: ArrayList<CallLogsArray>,
    val createdAt: String,
    val updatedAt: String,
    val disease: String,
    val specialization: String,
)

data class DoctorChatArray(
    val msg: String,
    val msgType: String,
    val from: String,
    val profile: String,
    val username: String,
    val id: String,
    val updateAt: String,
    val createAt: String,
)

data class FollowUpArray(
    val doctorId: String,
    val status: String,
    val id: String,
    val updateAt: String,
    val createAt: String,
    val callDuration: ArrayList<CallLogsArray>,
    val closeFollowUpTime: String,
)

data class CallLogsArray(
    val type: String,
    val duration: Int,
    val id: String,
    val createdAt: String,
    val updateAt: String,
    val v: Int,
    val doctorName: String,
)

/* ConverterFactory */

class ConsultationConverter{

    @TypeConverter
    fun consultToJson(value: List<ConsultationData>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToConsult(value: String) = Gson().fromJson(value,Array<ConsultationData>::class.java).toList()

}

class DoctorChatConverter {

    @TypeConverter
    fun docChatToJson(value: List<DoctorChatArray>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToDocList(value: String) =
        Gson().fromJson(value, Array<DoctorChatArray>::class.java).toList()
}

class CallLogsConverter{

    @TypeConverter
    fun callLogToJson(value:List<CallLogsArray>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToCallLogs(value:String) = Gson().fromJson(value, Array<CallLogsArray>::class.java).toList()
}

class FollowUpConverter{

    @TypeConverter
    fun followUpToJson(value:List<FollowUpArray>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToFollowUp(value:String) = Gson().fromJson(value,Array<FollowUpArray>::class.java).toList()

}
