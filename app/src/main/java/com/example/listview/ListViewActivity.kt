package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.result.Result2

class ListViewActivity : AppCompatActivity() {

    val context = this
    var listView: ListView? =null
    var myListAdapter:MyListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        初始化ListView()
    }
    private fun 初始化ListView(){
    //資料 適配器
    myListAdapter = MyListAdapter()
    //尋找 ListView
    listView = findViewById<ListView>(R.id.listview)
    //設定 ListView 資料適配器
    listView?.adapter = myListAdapter
    //設定資料0筆時要顯示那個View(通常用TextView顯示 目前沒有資料)
    listView?.emptyView = findViewById<TextView>(R.id.empty)
    //設定(監聽器)點選項目OnItemClick要執行的程式
        listView?.setOnItemClickListener{parent,view,position,id->
            val r2 = listView?.adapter?.getItem(position)
            val s = "position=" + position +" " +r2.toString()
            Log.d("@@@",s)

        }
    }

    fun click_add(v:View){
        //圖片陣列 新增 p04 圖片id
        myListAdapter?.drawableArrayList?.add(R.drawable.p04)
        //學生陣列 新增Mary
        val r2 = Result2("Mary",87,67)
        myListAdapter?.stArrayList?.add(r2)
        //資料有異動,通知ListView畫面需要更新
        myListAdapter?.notifyDataSetChanged()
        //顯示 短訊息
        Toast.makeText(context,"資料新增完成", Toast.LENGTH_SHORT).show()
        }
    //inner 內部類別 可使用外部類別資料,包含private資料
    inner class MyListAdapter: BaseAdapter(){ //繼承BaseAdapter
        //圖片陣列:arrayListOf() 快速建立ArrayList資料
        val drawableArrayList = arrayListOf<Int>(
            R.drawable.p01,
            R.drawable.p02,
            R.drawable.p03,
        )
        //學生陣列
        val stArrayList= arrayListOf<Result2>(
            Result2("Tom",87,96),
            Result2("Lisa",75,68),
            Result2("John",90,94),
        )
        override fun getCount():Int{
            return stArrayList.size
        }
        override  fun getItem(position:Int):Any{
            val r2 = stArrayList.get(position)
            return r2
        }
        //
        override fun getItemId(position:Int):Long{
            val itemId = position + 0L
            return itemId
        }
        override fun getView(position:Int,convertView:View?,parent: ViewGroup?):View{
            val itemLayout = context.layoutInflater.inflate(R.layout.item_layout,null)

            val iv_image = itemLayout.findViewById<ImageView>(R.id.iv_item_image)
            val tv_item_n = itemLayout.findViewById<TextView>(R.id.tv_item_n)
            val tv_item_e = itemLayout.findViewById<TextView>(R.id.tv_item_e)
            val tv_item_m = itemLayout.findViewById<TextView>(R.id.tv_item_m)

        val drawableId = drawableArrayList.get(position)
        val r2 = stArrayList.get(position)
            iv_image.setImageResource(drawableId)
            tv_item_n.setText(r2.name)
            tv_item_e.setText(r2.eng.toString())
            tv_item_m.setText(r2.math.toString())

            return itemLayout
        }


    }
}