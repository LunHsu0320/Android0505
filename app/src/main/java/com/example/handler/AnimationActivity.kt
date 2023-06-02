package com.example.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class AnimationActivity : AppCompatActivity() {

    lateinit var img_arraylist:ArrayList<Int>

    lateinit var btn_start:Button
    lateinit var btn_stop:Button
    lateinit var btn_reset:Button

    lateinit var tv_message:TextView
    lateinit var img:ImageView

    lateinit var handler:Handler
    lateinit var task:MyTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
    }
}