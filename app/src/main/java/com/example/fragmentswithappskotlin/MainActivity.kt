package com.example.fragmentswithappskotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentswithappskotlin.camera.CameraFragment
import com.example.fragmentswithappskotlin.databinding.ActivityMainBinding
import com.example.fragmentswithappskotlin.dice.DiceFragment
import com.example.fragmentswithappskotlin.weather.WeatherFragment

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
//        bottom_navigation.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//
//                R.id.calculator -> {
//                    val intent = Intent(this, CalculatorActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                R.id.camera -> {
//                    val intent = Intent(this, CameraOpenActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                R.id.weather -> {
//                    val intent = Intent(this, DiceActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                else -> false
//
//            }


    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }
}