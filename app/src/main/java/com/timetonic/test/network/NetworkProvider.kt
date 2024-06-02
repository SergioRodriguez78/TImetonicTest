package com.timetonic.test.network

import com.timetonic.test.BuildConfig
import com.timetonic.test.login.data.remote.LoginApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkProvider {
    fun provideNetwork(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.MAIN_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)
}
