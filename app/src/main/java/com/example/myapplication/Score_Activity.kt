package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import android.view.View


class Score_Activity : AppCompatActivity() {

    private var score = 0
    private var tv_score: TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        初值設定()
    }
    fun 初值設定(){
        score = 0
        tv_score = findViewById(R.id.tv_score);
    }
    fun 顯示得分(){
        var s = "" +score
        Log.d("@@@",s)
        tv_score?.setText(s)

    }
    fun clickAdd(view:View?){
        var id = view?.getId()
        when(id){
            R.id.btn_p3 ->{
                score += 3
                顯示得分()
            }
            R.id.btn_p2 ->{
                score += 2
                顯示得分()
            }
            R.id.btn_p1 ->{
                score += 1
                顯示得分()
            }
            R.id.btn_m3 ->{
                score -= 3
                顯示得分()
            }
            R.id.btn_m2 ->{
                score -= 2
                顯示得分()
            }
            R.id.btn_m1 ->{
                score -= 1
                顯示得分()
            }
            R.id.btn_reset ->{
                score = 0
                顯示得分()
            }
        }
    }
}