package dev.luciah.workoutlog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.luciah.workoutlog.R

class HomeActivity : AppCompatActivity() {
    lateinit var fcvHome: FragmentContainerView
    lateinit var bnvHome: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        costView()
        setUpBottomNav()
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