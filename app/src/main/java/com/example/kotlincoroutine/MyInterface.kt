package com.example.kotlincoroutine

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Observable

interface MyInterface {

    @GET("marvel/")
   // suspend fun getString(): Response<String>
   fun getData() :Observable<List<ModelListView>>









}