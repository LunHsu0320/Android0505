package com.example.scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.R
import com.example.result.Result2


class ScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
    }
    fun click_add(v: View){
        var r2 = Result2("Tom",76,84)

        //畫面佈局 載入器
        var li : LayoutInflater = LayoutInflater.from(this)
        //載入R.layout.scroll_student 到 ScrollView 裡 LinearLayout
        var ll: LinearLayout = findViewById(R.id.ll)
        //載入器功能 inflate 載入資料 R.layout.scroll_student 到 LinearLayout
        var v:View = li.inflate(R.layout.scroll_student,ll,false)
        //ll加入v的資料
        ll.addView(v)

        // 在載入的ll視圖中查找 TextView 元素
        var tv_name:TextView = v.findViewById(R.id.tv_n)
        var tv_eng:TextView = v.findViewById(R.id.tv_e)
        var tv_math:TextView = v.findViewById(R.id.tv_m)

        // 設置 TextView 的內容
        tv_name.text = r2.name
        tv_eng.text = r2.eng.toString()
        tv_math.text = r2.math.toString()

    }
}