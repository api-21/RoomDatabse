package com.xpresscure.roomdatabse.LocalStorage.RoomDi

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

//@Entity(tableName = "consultation")
//data class ConsultationCollection(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
//    val listOfConsultation: ArrayList<ConsultationData>
//)
//
//data class ConsultationData(
//    var _id: String,
//    var user_id: String,
//    var doctor_id: String,
//    var patient_name: String,
//    var patient_img: String,
//    var algoStatus: String,
//    var consultStatus: String,
//    var status: String,
//    var booked_time: String,
//    var freefollowup: String,
//    var patient_fees: String,
//    var patientstatus: String,
//    var answeredCount: Int,
//    var jiaAnsweredCount: Int,
//    var appType: String,
//    var doctorChat: ArrayList<DoctorChatArray>,
//    var followUp: ArrayList<FollowUpArray>,
//    var callLog: ArrayList<CallLogsArray>,
//    var createdAt: String,
//    var updatedAt: String,
//    var disease: String,
//    var specialization: String,
//){
//    companion object{
//        class ConsultationDataConverters {
//            companion object{
//                @JvmStatic
//                @TypeConverter
//                fun listToJson(value: List<ConsultationData>?) = Gson().toJson(value)
//
//                @JvmStatic
//                @TypeConverter
//                fun jsonToList(value: String) = Gson().fromJson(value, Array<ConsultationData>::class.java)
//            }
//
//        }
//    }
//}

data class DoctorChatArray(
    var msg: String,
    var msgType: String,
    var from: String,
    var profile: String,
    var username: String,
    var id: String,
    var updateAt: String,
    var createAt: String,
){
    class DoctorChatArrayConverters {
        companion object{
            @TypeConverter
            fun listToJson(value: List<DoctorChatArray>?) = Gson().toJson(value)

            @TypeConverter
            fun jsonToList(value: String) = Gson().fromJson(value, Array<DoctorChatArray>::class.java)
        }
    }

}

data class FollowUpArray(
    var doctorId: String,
    var status: String,
    var id: String,
    var updateAt: String,
    var createAt: String,
    var callDuration: ArrayList<CallLogsArray>,
    var closeFollowUpTime: String,
){
    class FollowUpArrayConverters {
        companion object{
            @JvmStatic
            @TypeConverter
            fun listToJson(value: List<FollowUpArray>?) = Gson().toJson(value)

            @JvmStatic
            @TypeConverter
            fun jsonToList(value: String) = Gson().fromJson(value, Array<FollowUpArray>::class.java)
        }


    }

}

data class CallLogsArray(
    var type: String,
    var duration: Int,
    var id: String,
    var createdAt: String,
    var updateAt: String,
    var v: Int,
    var doctorName: String,
) {
    class CallLogsArrayConverters {

        companion object {
            @JvmStatic
            @TypeConverter
            fun listToJson(value: List<CallLogsArray>?) = Gson().toJson(value)

            @TypeConverter
            fun jsonToList(value: String) = Gson().fromJson(value, Array<CallLogsArray>::class.java)
        }


    }
}



