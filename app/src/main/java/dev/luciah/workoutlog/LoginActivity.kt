package dev.luciah.workoutlog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var tilEmail1: TextInputLayout
    lateinit var tilPassword2: TextInputLayout
    lateinit var etEmail1: EditText
    lateinit var etPassword2: EditText
    lateinit var btnLogin: Button
    lateinit var tvSignup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignup = findViewById(R.id.tvSignup)
        btnLogin.setOnClickListener {
            validateLogin()

        }
        tvSignup.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        tilEmail1 = findViewById(R.id.tilEmail1)
        tilPassword2 = findViewById(R.id.tilPassword2)
        etEmail1 = findViewById(R.id.etEmail1)
        etPassword2 = findViewById(R.id.etPassword2)


    }

    fun validateLogin() {
        var email = etEmail1.text.toString()
        var password = etPassword2.text.toString()
        if (email.isBlank()) {
            tilEmail1.error = "Email is required"
            if (password.isBlank()) {
                tilPassword2.error = "Password is required"
            }


        }
    }
}
