package com.example.fragmentswithappskotlin.weather.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
//    https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=42e1fb65aa9d7209eb6dfc56760ea031
    private const val BASE_URL: String =
        "https://api.openweathermap.org/"
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}