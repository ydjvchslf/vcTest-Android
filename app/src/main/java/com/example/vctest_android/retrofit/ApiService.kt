package com.example.vctest_android.retrofit

import com.example.vctest_android.dateModel.User
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/get")
    fun getUser(): Call<User>
}