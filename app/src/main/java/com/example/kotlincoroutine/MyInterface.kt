package com.example.kotlincoroutine

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyInterface {

    @GET("marvel/")
   // suspend fun getString(): Response<String>
    suspend fun getData() :Response<List<ModelListView>>

}