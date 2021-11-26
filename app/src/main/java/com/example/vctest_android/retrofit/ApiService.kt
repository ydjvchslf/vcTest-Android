package com.example.vctest_android.retrofit

import com.example.vctest_android.model.Product
import com.example.vctest_android.model.User
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("api/get")
    fun getUser(): Call<User>

    //fake api test
    @POST("/products")
    fun createProduct(@Body product: Product): Call<Product>

    @PUT("products/{number}") // Q. path맞는지? int인지 string인지 어떻게 알지?
    fun updateProduct(@Path("number") number: Int, @Body product: Product): Call<Product>

    @DELETE("products/{number}")
    fun deleteProduct(@Path("number") number: String): Call<Unit>
}