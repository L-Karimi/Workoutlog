package dev.luciah.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.luciah.workoutlog.models.LoginResponse
import dev.luciah.workoutlog.repository.UserRepository

class UserViewModel : ViewModel() {
    val userRepository = UserRepository()
    var loginResponseLiveData = MutableLiveData<LoginResponse>()
    val loginErrorLiveData = MutableLiveData<String>()
}
