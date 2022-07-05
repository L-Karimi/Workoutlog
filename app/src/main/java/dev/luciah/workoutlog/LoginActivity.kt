package dev.luciah.workoutlog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.luciah.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            validateLogin()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        finish()

    }

    fun validateLogin() {
        val email = binding.etEmail1.text.toString()
        val password = binding.etPassword2.text.toString()
        var error = false

        if (email.isBlank()) {
            binding.tilEmail1.error = "Email is required"
            error = true

            if (password.isBlank()) {
                binding.tilPassword2.error = "Password is required"
                error = true
            }


        }
    }
}
