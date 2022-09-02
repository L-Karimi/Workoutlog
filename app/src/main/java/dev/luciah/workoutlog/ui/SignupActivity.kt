package dev.luciah.workoutlog.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.luciah.workoutlog.R
import dev.luciah.workoutlog.databinding.ActivitySignupBinding
import dev.luciah.workoutlog.models.RegisterRequest
import dev.luciah.workoutlog.models.RegisterResponse
import dev.luciah.workoutlog.retrofit.ApiClient
import dev.luciah.workoutlog.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivitySignupBinding.inflate(layoutInflater)
//        binding.btnSignup.setOnClickListener {
//        }
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
        val email=binding.etEmail.text.toString()
        val password = binding.etpassword.text.toString()
        val phoneNumber = binding.tietPhonenum.text.toString()
        var error = false
        if (firstname.isBlank()) {
            error = true
            binding.tilFirstname.error = getString(R.string.enter_first_name)
        }
        if (lastname.isBlank()) {
            binding.tilLastname.error = getString(R.string.enter_last_name)
        }
        if (email.isBlank()){
            binding.tilEmail.error=getString(R.string.enter_email)
        }
        if (password.isBlank()){
            binding.etpassword.error=getString(R.string.enter_password)
        }
        if (password.length<8) {
            binding.tilConfirmpassword.error = "Password is too short"
        }
        if (password.length>16){
            binding.tilConfirmpassword.error="Password is too long"
        }
        if (phoneNumber.isBlank()) {
            binding.tietPhonenum.error = "Enter phone number"
        }
        if (!error) {
            val registerRequest = RegisterRequest(firstname, lastname, phoneNumber, password,email)
            makeRegistrationRequest(registerRequest)
        }
    }

    fun makeRegistrationRequest(registerRequest: RegisterRequest){
        val apiclient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiclient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse>, retrofit2.Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if(response.isSuccessful){
                    val message = response.body()?.message
                    Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()            }
                else{
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }

            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}





















































