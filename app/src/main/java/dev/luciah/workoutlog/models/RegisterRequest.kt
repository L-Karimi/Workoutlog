package dev.luciah.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_Name") var firstName: String,
    @SerializedName("last_Name") var lastName: String,
   @SerializedName("password") var password: String,
   @SerializedName("email") var email:String
)
