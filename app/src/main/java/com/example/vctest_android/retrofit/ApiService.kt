package com.example.vctest_android.retrofit

import com.example.vctest_android.model.Product
import com.example.vctest_android.model.User
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("api/get")
    fun getUser(): Call<User>

    //fake api test
    @POST("/products")
    fun createProduct(@Body product: Product): Call<Product>
}