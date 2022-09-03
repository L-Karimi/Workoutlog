package dev.luciah.workoutlog.retrofit

import dev.luciah.workoutlog.models.LoginRequest
import dev.luciah.workoutlog.models.LoginResponse
import dev.luciah.workoutlog.models.RegisterRequest
import dev.luciah.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun  registerUser(@Body registerRequest:RegisterRequest):Call<RegisterResponse>

    @POST("/login")
    fun  login (@Body loginRequest: LoginRequest):Call<LoginResponse>

}