package com.example.vctest_android.retrofit

import android.util.Log
import com.example.vctest_android.utill.Constants.Companion.BASE_URL
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {

    val TAG: String = "LOG"

    companion object{
        //스스로 자신의 인스턴스를 가져온다
        val instance = RetrofitManager()
    }

    val HttpCall : ApiService?= RetrofitClient.getClient(BASE_URL)?.create(ApiService::class.java)

    fun getTodo(){

        val call = HttpCall?.getUser()

        call?.enqueue(object : retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() 호출 - OK~~~ / t : response -> ${response} , response.body() -> ${response.body()}")
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() 호출 - NO!!! / t : ${t}")
            }
        })
    }


}