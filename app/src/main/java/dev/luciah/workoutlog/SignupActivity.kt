package dev.luciah.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
lateinit var  tilFirstname:TextInputLayout
lateinit var etFirstname:TextInputEditText
lateinit var tilLastname:TextInputLayout
lateinit var etLastname:TextInputEditText
lateinit var tilPassword:TextInputLayout
lateinit var etPassword: EditText
lateinit var tilConfirmpassword:TextInputLayout
lateinit var etConfirmpassword:EditText
lateinit var btnSignup:Button
lateinit var tvLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnSignup.setOnClickListener {

        }
        tvLogin.setOnClickListener {
            startActivity(this,LoginActivity::class.java)
        }
        tilFirstname=findViewById(R.id.tilFirstname)
        tilLastname=findViewById(R.id.tilLastname)

        tilPassword=findViewById(R.id.tilPassword)
        tilConfirmpassword=findViewById(R.id.tilConfirmpassword)
        etFirstname=findViewById(R.id.etFirstname)
        etLastname=findViewById(R.id.etLastname)
        etPassword=findViewById(R.id.etPassword)
        etConfirmpassword=findViewById(R.id.etConfirmpassword)
        tvLogin =findViewById(R.id.tvLogin)

    }
    fun validateSignup () {
        var firstname = etFirstname.text.toString()
        var lastname = etLastname.text.toString()
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var confirm_password = etConfirmpassword.text.toString()

        if (firstname . isBlank()) {
            tilFirstname.error = "First name is required"
        }
        if (lastname . isBlank()) {
            tilLastname. error = "Last name is required"
        }
        if (email . isBlank()) {
            tilEmail.error = "Email is required"
        }
        if (password. isBlank()) {
            tilPassword.error = "Password is required"
        }
        if (confirm_password. isBlank()) {
            tilConfirmpassword.error = "confirm password required"

        }
        if (password != confirm_password) {
            tilPassword.error = "wrong password"

        }
}























































