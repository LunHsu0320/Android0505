package com.example.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.view.View
import com.example.myapplication.R
import com.example.result.KEY_r2
import com.example.result.Result2
import com.example.storeactivity.Student
import java.io.Serializable

const val KEY_or1 = "KEY_Order1"
const val KEY_or2 = "KEY_Order2"
const val KEY_or3 = "KEY_Order3"
class OrderActivity3 : AppCompatActivity() {
    private var 漢堡數量:Int=0
    private var 薯條數量:Int=0

    private var 漢堡單價:Int=0
    private var 薯條單價:Int=0

    private var 總金額:Int=0

    private var tv_漢堡數量:TextView?=null
    private var tv_薯條數量:TextView?=null
    private var tv_總金額:TextView?=null

    private var ol: OrderList? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order3)
        初始設定()
    }
    fun 初始設定(){
        tv_漢堡數量=findViewById(R.id.tv_漢堡數量)
        tv_薯條數量=findViewById(R.id.tv_薯條數量)
        tv_總金額=findViewById(R.id.tv_總金額)
        漢堡數量=0
        薯條數量=0
        總金額=0
        漢堡單價=50
        薯條單價=30
    }
    fun 顯示漢堡數量(){
        var s =""+漢堡數量
        tv_漢堡數量?.setText(s)
    }
    fun 漢堡數量加1(){
        漢堡數量+=1
    }
    fun 漢堡數量減1(){
        if(漢堡數量>0){
            漢堡數量-=1
        }
    }
    fun click漢堡加(view:View?){
        漢堡數量加1()
        顯示漢堡數量()

    }
    fun click漢堡減(view:View?){
        漢堡數量減1()
        顯示漢堡數量()

    }

    fun 顯示薯條數量(){
        var s =""+薯條數量
        tv_薯條數量?.setText(s)
    }
    fun 薯條數量加1(){
        薯條數量+=1
    }
    fun 薯條數量減1(){
        if(薯條數量>0){
            薯條數量-=1
        }
    }

    fun click薯條加(view:View?){
        薯條數量加1()
        顯示薯條數量()

    }
    fun  click薯條減(view:View?){
        薯條數量減1()
        顯示薯條數量()

    }
    private fun 顯示總金額(){
        val s = "NT$ " + 總金額
        Log.d("@@@",s)
        tv_總金額?.setText(s)

    }
    fun clickOrder (View:View?){
        總金額=(漢堡單價*漢堡數量)+(薯條單價*薯條數量)
        顯示總金額()

        val intent = Intent(this, OrderActivity3_2::class.java)
        intent.putExtra("漢堡數量", 漢堡數量)
        intent.putExtra("薯條數量", 薯條數量)
        intent.putExtra("總金額", 總金額)

        startActivity(intent)
    }
    fun clickReset(View:View?){
        初始設定()
        顯示漢堡數量()
        顯示薯條數量()
        顯示總金額()
    }

}
