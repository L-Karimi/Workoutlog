package dev.luciah.workoutlog.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.luciah.workoutlog.R
import dev.luciah.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var btnlogout:Button
    lateinit var binding:ActivityHomeBinding
    lateinit var sharedPref:SharedPreferences
    lateinit var fcvHome: FragmentContainerView
    lateinit var bnvHome: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        costView()
        setUpBottomNav()


        binding.bnvHome.setOnClickListener {
            sharedPref = getSharedPreferences("WORKOUTLOG_PREFS", Context.MODE_PRIVATE)
            val editor=sharedPref.edit()
            editor.putString("ACCESS_TOKEN", "")
            editor.putString("USER_ID", "")
            editor.putString("PROFILE_ID", "")
            editor.apply()
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    fun costView() {
        fcvHome = findViewById(R.id.fragmentPlan)
        bnvHome = findViewById(R.id.bnvHome)
    }

    fun setUpBottomNav() {
        bnvHome.setOnItemSelectedListener {   item ->
            when (item.itemId) {
                R.id.plan -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentPlan, PlanFragment())
                    transaction.commit()
                    true
                }
                R.id.track -> {
                     supportFragmentManager.beginTransaction().replace(R.id.fragmentPlan, TrackFragment()).commit()
                    true
                }
                R.id.profile -> {
                      supportFragmentManager.beginTransaction().replace(R.id.fragmentPlan, ProfileFragment()).commit()
                    true
                }
                else -> false
            }

        }
    }
}