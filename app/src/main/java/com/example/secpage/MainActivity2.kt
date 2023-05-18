package com.example.secpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    fun btn_back(v: View){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}