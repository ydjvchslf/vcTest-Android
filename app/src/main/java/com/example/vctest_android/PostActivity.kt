package com.example.vctest_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.vctest_android.model.Product
import com.example.vctest_android.retrofit.RetrofitManager
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

class PostActivity : AppCompatActivity() {

    val TAG: String = "LOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

//        var title: EditText = findViewById(R.id.title)
//        var titleString : String = title.text.toString()
//
//        val price: EditText = findViewById(R.id.price)
//        var priceInt : Int = price.text.toString().toInt()
//
//        val description: EditText = findViewById(R.id.description)
//        var descriptionString : String = description.text.toString()
//
//        val image: EditText = findViewById(R.id.image)
//        var imageString : String = image.text.toString()
//
//        val category: EditText = findViewById(R.id.category)
//        var categoryString : String = category.text.toString()

        val createBtn: Button = findViewById(R.id.create_btn)
        createBtn.setOnClickListener {
            Log.d(TAG, "[PostActivity] 버튼 클릭")

            RetrofitManager.postRequest()
        }


    }
}