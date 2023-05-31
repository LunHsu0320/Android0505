package com.example.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R
import com.example.result.Result2
import com.example.result.Result2Activity

class OrderActivity3_2 : AppCompatActivity() {
    private var tv_漢堡數量: TextView? = null
    private var tv_薯條數量: TextView? = null
    private var tv_總金額: TextView? = null
    private var ol: OrderList? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order32)
        顯示訂單()
    }

    fun 初始設定(){
        tv_漢堡數量=findViewById(R.id.tv_漢堡數量)
        tv_薯條數量=findViewById(R.id.tv_薯條數量)
        tv_總金額=findViewById(R.id.tv_總金額)

    }

        fun btn_back(v: View){
        finish()
    }

    fun btn_submit(v: View){
        val intent = Intent(this, OrderActivity3::class.java)
        startActivity(intent)
    }
    fun 顯示訂單() {
        初始設定()
        val intent = getIntent()
        val 漢堡數量 = intent.getIntExtra("漢堡數量", 0)
        val 薯條數量 = intent.getIntExtra("薯條數量", 0)
        val 總金額 = intent.getIntExtra("總金額", 0)

        Log.d("@@@", "漢堡數量: $漢堡數量")
        Log.d("@@@", "薯條數量: $薯條數量")
        Log.d("@@@", "總金額: $總金額")

        var a = 漢堡數量.toString()
        Log.d("@@@", a)
        tv_漢堡數量?.text = a

        var b = 薯條數量.toString()
        Log.d("@@@", b)
        tv_薯條數量?.text = b

        val c = "NT$ $總金額"
        Log.d("@@@", c)
        tv_總金額?.text = c
    }

}