package com.example.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R


class AnimationActivity : AppCompatActivity() {
    //lateinit 稍後會設定初值 不會是空值
    lateinit var img_arraylist: ArrayList<Int>

    lateinit var btn_start: Button
    lateinit var btn_stop: Button
    lateinit var btn_reset: Button

    lateinit var tv_message: TextView
    lateinit var img: ImageView

    lateinit var handler: Handler //任務 管理員
    lateinit var task: MyTask //任務

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        init() // 初始化initialize(初值設定)
    }

    fun init() {
        //陣列 圖片id
        img_arraylist = arrayListOf<Int>(
            R.drawable.p01,
            R.drawable.p02,
            R.drawable.p03,
        )
        img = findViewById(R.id.img)
        //將背景設置為給指定的資源。
        img.setBackgroundResource(R.drawable.noimage)//設定圖片

        tv_message = findViewById(R.id.tv_message)

        btn_start = findViewById(R.id.btn_start)
        btn_stop = findViewById(R.id.btn_stop)
        btn_reset = findViewById(R.id.btn_reset)

        //設定 按鈕 監聽器
        btn_start.setOnClickListener(StartOnClick())
        btn_stop.setOnClickListener(StopOnClick())
        btn_reset.setOnClickListener(ResetOnClick())

        //建立 任務 管理員
        handler = Handler(Looper.getMainLooper())

        //建立 任務
        task = MyTask()
    }

    //任務
    inner class MyTask : Runnable {
        var count = 0 //換圖次數
        var i = 0 //第幾張圖
        var isDone = false //任務是否完成

        override fun run() {
            if (isDone) {
                return
            }
            btn_start.isEnabled = false  //start按鈕 無作用(不可按)
            //顯示訊息
            tv_message.text = "i=" + i.toString() + " count=" + count
            //顯示圖片
            val imgId = img_arraylist.get(i)
            img.setBackgroundResource(imgId)
            //若 i 加 1 後 等於 陣列大小
            if (++i == img_arraylist.size) {
                i = 0
            }
            //提交任務 1000毫秒(1秒) 後執行
            handler.postDelayed(this, 1000)

            //若 count 加 1 後 大於 9
            if (++count > 9) {
                isDone = true //任務完成
                btn_start.isEnabled = true //start按鈕 有作用(可按)
            }

        }

        fun reset() {
            i = 0
            count = 0
            isDone = false
        }
    }


    //OnClick 監聽器
    inner class StartOnClick : OnClickListener {
        override fun onClick(v: View?) {
            //提交任務 1000毫秒(1秒) 後執行
            handler.postDelayed(task, 1000)
        }
    }

    //OnClick 監聽器
    inner class StopOnClick : OnClickListener {
        override fun onClick(v: View?) {
            handler.removeCallbacks(task) //移除任務
            btn_start.isEnabled = true //start按鈕 有作用(可按)
        }
    }

    inner class ResetOnClick : OnClickListener {
        override fun onClick(v: View?) {
            tv_message.text = "目前沒有訊息"
            img.setBackgroundResource(R.drawable.noimage)
            btn_start.isEnabled = true //start按鈕 有作用(可按)
            task.reset()
        }
    }
}