package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.listview.ListViewActivity
import com.example.order.OrderActivity3
import com.example.result.ResultMainActivity
import com.example.scroll.ScrollActivity
import com.example.secpage.MainActivity2
import com.example.storeactivity.StoreActivity
import com.example.viewpager2.PagerActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_go2(v: View) {
        var intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)//切換畫面
    }

    fun btn_od(v: View) {
        var intent = Intent(this, OrderActivity3::class.java)
        startActivity(intent)//切換畫面
    }

    fun btn_rm(v: View) {
        var intent = Intent(this, ResultMainActivity::class.java)
        startActivity(intent)//切換畫面
    }

    fun btn_sa(v: View) {
        var intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)//切換畫面
    }
    fun btn_scrolla(v: View) {
        var intent = Intent(this, ScrollActivity::class.java)
        startActivity(intent)//切換畫面
    }
    fun btn_listv(v: View) {
        var intent = Intent(this, ListViewActivity::class.java)
        startActivity(intent)//切換畫面
    }
    fun btn_pa(v: View) {
        var intent = Intent(this, PagerActivity::class.java)
        startActivity(intent)//切換畫面
    }
}