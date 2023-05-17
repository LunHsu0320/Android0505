package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

const val KEY_r1 = "KEY_Result1"

class Result1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reslut1)
    }
    fun clickmitsu(view:View){
        var 圖片id:Int
        var 圖片名稱:String

        圖片id = R.drawable.mitsubaaoi
        圖片名稱 = "武田家徽"

        var r1 = Result1(圖片id,圖片名稱)
        Log.d("@@@ 寄結果",r1.toString())

        val intent = getIntent()
        intent.putExtra(KEY_r1,r1)

        setResult(RESULT_OK,intent);
        finish();
    }
    fun clickroku(view:View){
        var 圖片id:Int
        var 圖片名稱:String

        圖片id = R.drawable.rokumonsen
        圖片名稱 = "真田家徽"

        var r1 = Result1(圖片id,圖片名稱)
        Log.d("@@@ 寄結果",r1.toString())

        val intent = getIntent()
        intent.putExtra(KEY_r1,r1)

        setResult(RESULT_OK,intent);
        finish()
    }
}