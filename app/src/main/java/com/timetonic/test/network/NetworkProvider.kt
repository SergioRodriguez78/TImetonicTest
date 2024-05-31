package com.timetonic.test.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkProvider {
    fun provideNetwork(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
