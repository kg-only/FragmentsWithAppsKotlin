package com.example.fragmentswithappskotlin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentswithappskotlin.camera.CameraFragment
import com.example.fragmentswithappskotlin.databinding.ActivityMainBinding
import com.example.fragmentswithappskotlin.dice.DiceFragment
import com.example.fragmentswithappskotlin.weather.WeatherFragment
import com.example.fragmentswithappskotlin.weather.retrofit.RetrofitClient
import com.example.fragmentswithappskotlin.weather.retrofit.RetrofitService
import com.example.fragmentswithappskotlin.weather.models.WeatherDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val diceFragment = DiceFragment()
    private val cameraFragment = CameraFragment()
    private val weatherFragment = WeatherFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(diceFragment)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dice_menu -> replaceFragment(diceFragment)
                R.id.camera_menu -> replaceFragment(cameraFragment)
                R.id.weather_menu -> replaceFragment(weatherFragment)
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }

}