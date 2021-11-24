package com.example.vctest_android.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 레트로핏 클라이언트 클래스
// 메모리는 하나 사용하는 싱글턴 패턴을 적용해서 어디서든 하나의 객체를 가져온다
object RetrofitClient {
    val TAG: String = "LOG"

    // 레트로핏 클라이언트 선언
    private var retrofitClient : Retrofit? = null

    // 레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String) : Retrofit? {

        // 레트로핏 클라이언트가 없으면 생성, 있으면 있는거 가져오기 (싱글턴패던)
        if (retrofitClient == null){
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofitClient
    }


}