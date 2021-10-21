package com.example.fragmentswithappskotlin.weather.retrofit

import com.example.fragmentswithappskotlin.weather.models.WeatherDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("data/2.5/weather")
    fun getWeatherList(
        @Query("app_id") key:String
    ):Call<WeatherDataClass>

}