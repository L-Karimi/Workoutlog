package dev.luciah.workoutlog.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.luciah.workoutlog.apiclient
import dev.luciah.workoutlog.databinding.ActivitySignupBinding
import dev.luciah.workoutlog.models.RegisterRequest
import dev.luciah.workoutlog.models.RegisterResponse
import javax.security.auth.callback.Callback

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        binding.btnSignup.setOnClickListener {
        }
        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSignup() {
        val firstname = binding.etFirstname.text.toString()
        val lastname = binding.etLastname.text.toString()
        val password = binding.etpassword.text.toString()

        if (firstname.isBlank()) {
            binding.tilFirstname.error = "First name is required"
        }
        if (lastname.isBlank()) {
            binding.tilLastname.error = "Last name is required"
        }

        if (password.isBlank()) {
            binding.tilEmail.error = "Email is required"
        }
//        if (!error()){
//            val registerRequest=RegisterRequest(firstname,lastname ,password){
//
//            }
//        }
//    }
//    fun makeRegistration request(registerRequest:RegisterREquest){
//        var Apiclient=apiclient(ApiInterface::class.java)
//        var request=apiclient.registerUser(registerRequest)
//        request.enque(object :Callback<RegisterResponse>)
    }
}























































