package com.example.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.view.View
import com.example.myapplication.R

class OrderActivity2 : AppCompatActivity() {
    private var 數量:Int=0
    private var 單價:Int=0
    private var 總金額:Int=0

    private var tv_數量:TextView?=null
    private var tv_總金額:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order2)
        初值設定()
    }
    fun 初值設定(){
        tv_數量= findViewById(R.id.tv_數量)
        tv_總金額=findViewById(R.id.tv_總金額)
        數量=0
        單價=50
    }
    fun 顯示數量(){
        var s =""+數量
        tv_數量?.setText(s)
    }
    fun 數量加1(){
        數量+=1
    }
    fun 數量減1(){
        if(數量>0){
            數量-=1
        }
    }
    fun click加(view:View?){
        數量加1()
        顯示數量()

    }
    fun  click減(view:View?){
        數量減1()
        顯示數量()

    }
    private fun 顯示總金額(){
        val s = "NT$ " + 總金額
        Log.d("@@@",s)
        tv_總金額?.setText(s)

    }
    fun clickOrder (View:View?){
        總金額=單價*數量
        顯示總金額()
    }
}