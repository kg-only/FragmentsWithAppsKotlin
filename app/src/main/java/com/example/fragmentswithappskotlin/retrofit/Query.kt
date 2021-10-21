package com.example.weather.retrofit

import com.example.weather.models.WeatherDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Query {
    @GET("data/2.5/weather")
    fun getWeatherList(
        @Query("42e1fb65aa9d7209eb6dfc56760ea031\n") key:String
    ):Call<WeatherDataClass>

}