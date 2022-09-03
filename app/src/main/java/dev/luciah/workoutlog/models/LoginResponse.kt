package dev.luciah.workoutlog.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message") var message:String,
    @SerializedName("accessToken")  var accessToken:String,
    @SerializedName("userId") var userId:String,
    @SerializedName("profileId") var profileId:String

)
