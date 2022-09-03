package dev.luciah.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.luciah.workoutlog.databinding.ActivityLoginBinding
import dev.luciah.workoutlog.models.LoginRequest
import dev.luciah.workoutlog.models.LoginResponse
import dev.luciah.workoutlog.retrofit.ApiClient
import dev.luciah.workoutlog.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences("WORKOUTLOG=PREFS", MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
            validateLogin()
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
            if (!error) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
            if (!error) {
                var loginRequest = LoginRequest(email, password)
                makeLoginRequest(loginRequest)
            }
        }
    }

    fun makeLoginRequest(loginRequest: LoginRequest) {
        val apiclient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiclient.login(loginRequest)
        request.enqueue(object : Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                binding.pbLogin.visibility = View.GONE

                if (response.isSuccessful) {
                    val loginResponse=response.body()
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG)
                    saveLoginDetails(loginResponse !!)
                    startActivity(Intent(baseContext,HomeActivity::class.java))
                    finish()

                } else {
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                binding.pbLogin.visibility = View.GONE
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }


        })
    }

    fun saveLoginDetails(loginResponse: LoginResponse) {
        val editor = sharedPref.edit()
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("PROFILE_ID", loginResponse.profileId)
        editor.apply()
    }
}



