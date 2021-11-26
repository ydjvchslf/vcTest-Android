package com.example.vctest_android.retrofit

import android.util.Log
import com.example.vctest_android.model.Product
import com.example.vctest_android.model.User
import com.example.vctest_android.utill.Constants.Companion.BASE_URL
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import kotlin.collections.HashMap

//object class 자체가 싱글턴패턴 (자기자신의 인스턴스를 리턴)
object RetrofitManager {

    val TAG: String = "LOG"

    // ApiService 인터페이스 인스턴스 생성
    val apiService : ApiService?= RetrofitClient.getClient(BASE_URL)?.create(ApiService::class.java)

    // return 값이 없으니 ajax위해 콜백함수 적용
    fun getTodo(callback: (HashMap<String, Any>) -> Unit){

        val resultMap = HashMap<String, Any>()

        val call: Call<User>? = apiService?.getUser()

        call?.enqueue(object : retrofit2.Callback<User> {
                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            Log.d(TAG, "[RetrofitManager] getTodo() 호출 : OK~ \n " +
                                    "response -> $response \n" +
                                    "response.body() -> ${response.body()} \n" + // Q. User가 객체인지, 아니면 dataModel거쳐온 User인지
                                    "response.body().name -> ${response.body()?.name}")

                            resultMap["result"] = "ok"
                            resultMap["user"] = response.body().toString() // Q. response.body() 를 넣을 순 없는가? type 뭐지?

                            Log.d(TAG, "[RetrofitManager] resultMap.result -> ${resultMap["result"]}")
                            Log.d(TAG, "[RetrofitManager] resultMap.user -> " + resultMap["user"])

                            callback.invoke(resultMap)
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            Log.d(TAG, "[RetrofitManager] getTodo() 호출 : NO!! \n t : $t")

                            resultMap.put("result", "no")

                            callback.invoke(resultMap)
                        }

        })
    }

    fun postRequest(){

        //mock data
        val call: Call<Product>? = apiService?.createProduct(Product("title_test", 50000, "desc_test", "image_test", "cate_test"))

        call?.enqueue(object : retrofit2.Callback<Product> {

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                Log.d(TAG, "[RetrofitManager] postRequest() 호출 : OK \n " +
                                "response -> $response \n" +
                                "response.body() -> ${response.body()} \n")
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d(TAG, "[RetrofitManager] postRequest() 호출 : NO!! \n t : $t")

            }
        })
    }

    fun putRequest(){

        //mock data
        val call: Call<Product>? = apiService?.updateProduct(7, Product("test1", 10, "test2", "test3", "test4"))

        call?.enqueue(object : retrofit2.Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                Log.d(TAG, "[RetrofitManager] putRequest() 호출 : OK \n " +
                        "response -> $response \n" +
                        "response.body() -> ${response.body()} \n")
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d(TAG, "[RetrofitManager] putRequest() 호출 : NO!! \n t : $t")
            }
        })
    }

    fun deleteRequest(){

        val call: Call<Unit>? = apiService?.deleteProduct("6")

        call?.enqueue(object : retrofit2.Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                Log.d(TAG, "[RetrofitManager] deleteRequest() 호출 : OK \n " +
                        "response -> $response \n" +
                        "response.body() -> ${response.body()} \n")
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(TAG, "[RetrofitManager] deleteRequest() 호출 : NO!! \n t : $t")
            }

        })


    }

}
