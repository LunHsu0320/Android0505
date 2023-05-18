package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

//val 變數不可修改(初值設定後不可修改 = 不能再指定新的數值)
//var 變數可修改
//const 全域常數(整個應用程式可用)
const val KEY_r1 = "KEY_Result1"

class Result1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reslut1)
    }

    fun click_mitsu(view: View) {
        var 圖片id: Int
        var 圖片名稱: String

        圖片id = R.drawable.mitsubaaoi
        圖片名稱 = "武田家徽"

        var r1 = Result1(圖片id, 圖片名稱)//建立物件 簡化new
        Log.d("@@@ 寄結果", r1.toString())

        //寄資料
        val intent = getIntent()
        intent.putExtra(KEY_r1, r1)

        //設定結果狀態
        //RESULT_OK
        //RESULT_CANCELED
        setResult(RESULT_OK, intent);
        finish();//結束目前Activity,返回之前Activity
    }

    fun click_roku(view: View) {
        var 圖片id: Int
        var 圖片名稱: String

        圖片id = R.drawable.rokumonsen
        圖片名稱 = "真田家徽"

        var r1 = Result1(圖片id, 圖片名稱)//建立物件 簡化new
        Log.d("@@@ 寄結果", r1.toString())

        //寄資料
        val intent = getIntent()
        intent.putExtra(KEY_r1, r1)

        //設定結果狀態
        //RESULT_OK
        //RESULT_CANCELED
        setResult(RESULT_OK, intent);
        finish();//結束目前Activity,返回之前Activity
    }
}