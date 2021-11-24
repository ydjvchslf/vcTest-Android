package com.example.vctest_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.vctest_android.retrofit.RetrofitManager

class MainActivity : AppCompatActivity() {

    val TAG: String = "LOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get_method_btn.setOnClickListener {} 왜안나와?
        findViewById<Button>(R.id.get_method_btn).setOnClickListener {
            Log.d(TAG, "get() 호출")
            RetrofitManager.instance.getTodo()
        }

        findViewById<Button>(R.id.post_method_btn).setOnClickListener {
            Log.d(TAG, "post() 호출")
        }

        findViewById<Button>(R.id.put_method_btn).setOnClickListener {
            Log.d(TAG, "put() 호출")
        }

        findViewById<Button>(R.id.delete_method_btn).setOnClickListener {
            Log.d(TAG, "delete() 호출")
        }



    }
}