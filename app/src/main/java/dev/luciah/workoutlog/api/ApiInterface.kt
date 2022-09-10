package dev.luciah.workoutlog.api

import dev.luciah.workoutlog.models.LoginRequest
import dev.luciah.workoutlog.models.LoginResponse
import dev.luciah.workoutlog.models.RegisterRequest
import dev.luciah.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun  registerUser(@Body registerRequest:RegisterRequest):Call<RegisterResponse>

    @POST("/login")
   suspend fun  login (@Body loginRequest: LoginRequest):Response<LoginResponse>

}