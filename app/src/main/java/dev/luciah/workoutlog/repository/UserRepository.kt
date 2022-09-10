package dev.luciah.workoutlog.repository

import dev.luciah.workoutlog.api.ApiClient
import dev.luciah.workoutlog.api.ApiInterface
import dev.luciah.workoutlog.models.LoginRequest
import dev.luciah.workoutlog.models.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest):
            Response<LoginResponse> =
        withContext(Dispatchers.IO) {
            var response = apiInterface.login(loginRequest )
            return@withContext response
        }
}