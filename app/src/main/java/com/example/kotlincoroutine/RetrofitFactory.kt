package com.example.kotlincoroutine

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitFactory {

    const val BASE_URL = "https://simplifiedcoding.net/demos/"

    fun makeRetrofitService(): MyInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MyInterface::class.java)

    }
}