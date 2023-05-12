package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class OrderActivity3_2 : AppCompatActivity() {
    private var tv_漢堡數量: TextView?=null
    private var tv_薯條數量: TextView?=null
    private var tv_總金額: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order32)
        顯示訂單()
    }
    fun btn_back(v: View){
        var intent = Intent(this,OrderActivity3::class.java)
        startActivity(intent)
    }
    fun 顯示訂單(){
        val intent = getIntent()
        val 漢堡數量 = intent.getIntExtra("漢堡數量", 0)
        val 薯條數量 = intent.getIntExtra("薯條數量", 0)
        val 總金額 = intent.getIntExtra("總金額", 0)
        var a =""+漢堡數量
        tv_漢堡數量?.setText(a)
        var b =""+薯條數量
        tv_薯條數量?.setText(b)
        val c = "NT$ " + 總金額
        Log.d("@@@",c)
        tv_總金額?.setText(c)
    }

}