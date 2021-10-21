package com.example.fragmentswithappskotlin.weather

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentswithappskotlin.R
import com.example.fragmentswithappskotlin.databinding.FragmentWeatherBinding
import com.example.fragmentswithappskotlin.weather.models.WeatherDataClass
import com.example.fragmentswithappskotlin.weather.retrofit.RetrofitClient
import com.example.fragmentswithappskotlin.weather.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

private lateinit var binding: FragmentWeatherBinding

class WeatherFragment : Fragment() {
    private val api: RetrofitService =
        RetrofitClient.getClient()!!.create(RetrofitService::class.java)

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

        val key = getString(R.string.weatherApiKey)
        api.getWeatherList(key).enqueue(object : Callback<WeatherDataClass> {
            override fun onResponse(
                call: Call<WeatherDataClass>,
                response: Response<WeatherDataClass>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    binding.tempTextView.text = data.main.temp.toString()
                    binding.cloudsTextView.text = data.clouds.all.toString()
                    binding.latTextView.text = data.coord.lat.toString()
                    binding.lonTextView.text = data.coord.lon.toString()
                }
            }

            override fun onFailure(call: Call<WeatherDataClass>, t: Throwable) {
                Log.e("Error", "Error getting weather", t)
                Toast.makeText(
                    requireActivity(),
                    "Something wrong, ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }

}



