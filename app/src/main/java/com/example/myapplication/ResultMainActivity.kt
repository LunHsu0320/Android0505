package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.util.Log

const val 請求編號_r1 = 1
const val 請求編號_r2 = 2

class ResultMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main)
    }

    fun btn_r1i(view: View) {
        var intent = Intent(this, Result1Activity::class.java)
        startActivityForResult(intent, 請求編號_r1)
    }

    fun btn_r2s(view: View) {
        var intent = Intent(this, Result2Activity::class.java)
        startActivityForResult(intent, 請求編號_r2)
    }

    override fun onActivityResult(請求編號: Int, 結果狀態: Int, 意圖: Intent?) {
        super.onActivityResult(請求編號, 結果狀態, 意圖)
        when (請求編號) {
            請求編號_r1 -> {
                if (結果狀態 == RESULT_OK) {
                    var r1 = 意圖?.getSerializableExtra(KEY_r1) as Result1
                    Log.d("@@@ 收結果", r1.toString())
                }
            }

            請求編號_r2 -> {
                if (結果狀態 == RESULT_OK) {
                    var r1 = 意圖?.getSerializableExtra(KEY_r1) as Result1
                    Log.d("@@@ 收結果", r1.toString())
                }
            }
        }
    }
}