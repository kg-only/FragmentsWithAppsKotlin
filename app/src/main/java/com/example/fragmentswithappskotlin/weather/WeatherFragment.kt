package com.example.fragmentswithappskotlin.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentswithappskotlin.databinding.FragmentWeatherBinding
import com.example.weather.models.WeatherDataClass
import com.example.weather.retrofit.Query
import com.example.weather.retrofit.RetrofitClient

private lateinit var binding: FragmentWeatherBinding

class WeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit: RetrofitClient
        var query:Query
    }

}



