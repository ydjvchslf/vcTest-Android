package com.example.vctest_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.*
import android.widget.Button
import android.widget.TextView
import com.example.vctest_android.retrofit.RetrofitManager
import android.content.Intent




class MainActivity : AppCompatActivity() {

    val TAG: String = "LOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView: TextView ?= null

        var resultMap: HashMap<String, Any>?= null

        textView = findViewById(R.id.textView)

        findViewById<Button>(R.id.get_method_btn).setOnClickListener {

            d(TAG, "[MainActivity] get() 호출")

            RetrofitManager.getTodo { resultMap ->
                d(TAG, "[MainActivity] resultMap => $resultMap")

                when(resultMap["result"]) {
                    "ok" -> textView.text = "호출 성공"
                    "no" -> textView.text = "호출 실패"
                }
            }
        }

        findViewById<Button>(R.id.post_move_btn).setOnClickListener {
            d(TAG, "[MainActivity] post_move_btn 클릭")

            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)

        }

        findViewById<Button>(R.id.put_method_btn).setOnClickListener {
            d(TAG, "[MainActivity] put() 호출")

            RetrofitManager.putRequest()
        }

        findViewById<Button>(R.id.delete_method_btn).setOnClickListener {
            d(TAG, "[MainActivity] delete() 호출")

            RetrofitManager.deleteRequest()
        }



    }
}