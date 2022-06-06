package dev.luciah.workoutlog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var tvSignup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            validateLogin()
        }
        btnLogin = findViewById(R.id.btnLogin)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvSignup = findViewById(R.id.tvSignup)


    }

    fun validateLogin() {
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
            if (password.isBlank()) {
                tilPassword.error = "Password is required"
            }


        }
    }
}
