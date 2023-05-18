package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
//val 變數不可修改(初值設定後不可修改 = 不能再指定新的數值)
//var 變數可修改
//const 全域常數(整個應用程式可用)
//常數const類似Java的public static final
const val 請求編號_r1 = 1
const val 請求編號_r2 = 2

class ResultMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main)
    }

    fun btn_r1i(view: View) {
        var intent = Intent(this, Result1Activity::class.java)
        startActivityForResult(intent, 請求編號_r1)//切換Activity請求結果
    }

    fun btn_r2s(view: View) {
        var intent = Intent(this, Result2Activity::class.java)
        startActivityForResult(intent, 請求編號_r2)//切換Activity請求結果
    }

    override fun onActivityResult(請求編號: Int, 結果狀態: Int, 意圖: Intent?) {
        super.onActivityResult(請求編號, 結果狀態, 意圖)
        when (請求編號) {
            請求編號_r1 -> {
                if (結果狀態 == RESULT_OK) {
                    var r1 = 意圖?.getSerializableExtra(KEY_r1) as Result1 //as轉型
                    Log.d("@@@ 收結果", r1.toString())

                    //顯示圖片 沒有使用ImageView? 表示不會是 null
                    var iv: ImageView = findViewById(R.id.iv)
                    iv.setImageResource(r1.圖片id)//.圖片id 簡化 .get圖片id()
                }
            }

            請求編號_r2 -> {
                var r2 = 意圖?.getSerializableExtra(KEY_r2) as Result2
                Log.d("@@@ 收結果", r2.toString())
                //顯示文字 沒有使用TextView? 表示不會是 null
                var tv_name: TextView = findViewById(R.id.tv_name)
                var tv_eng:TextView = findViewById(R.id.tv_eng)
                var tv_math:TextView = findViewById(R.id.tv_math)

                //setText() 簡化為 .text
                tv_name.text=r2.name
                tv_eng.text=r2.eng.toString()
                tv_math.text=r2.math.toString()
            }
        }
    }
}