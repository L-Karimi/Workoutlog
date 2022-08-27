package dev.luciah.workoutlog.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.luciah.workoutlog.databinding.ActivitySignupBinding

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


    }
}























































