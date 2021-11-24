package com.example.vctest_android.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/test")
    fun getUser(): Call<JsonElement>
}