package dev.luciah.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tilFirstname: TextInputLayout
    lateinit var etFirstname: TextInputEditText
    lateinit var tilLastname: TextInputLayout
    lateinit var etLastname: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etPassword: EditText
    lateinit var tilConfirmpassword: TextInputLayout
    lateinit var etConfirmpassword: EditText
    lateinit var btnSignup: Button
    lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignup = findViewById(R.id.btnSignup)
        tvLogin = findViewById(R.id.tvLogin)
        btnSignup.setOnClickListener {

        }
        tvLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            validateSignup()
        }
        tilFirstname = findViewById(R.id.tilFirstname)
        tilLastname = findViewById(R.id.tilLastname)

        tilEmail = findViewById(R.id.tilEmail)
        tilConfirmpassword = findViewById(R.id.tilConfirmpassword)
        etFirstname = findViewById(R.id.etFirstname)
        etLastname = findViewById(R.id.etLastname)
        etPassword = findViewById(R.id.etEmail)
        etConfirmpassword = findViewById(R.id.etConfirmpassword)

    }

    fun validateSignup() {
        var firstname = etFirstname.text.toString()
        var lastname = etLastname.text.toString()
        var password = etPassword.text.toString()
        var confirm_password = etConfirmpassword.text.toString()

        if (firstname.isBlank()) {
            tilFirstname.error = "First name is required"
        }
        if (lastname.isBlank()) {
            tilLastname.error = "Last name is required"
        }

        if (password.isBlank()) {
            tilEmail.error = "Email is required"
        }
        if (confirm_password.isBlank()) {
            tilConfirmpassword.error = " password required"

        }

    }
}























































