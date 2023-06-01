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
    var listView: ListView? = null
    var myListAdapter: MyListAdapter? = null
    private var r2Selected: Result2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        初始化ListView()
    }

    private fun 初始化ListView() {
        //資料 適配器
        myListAdapter = MyListAdapter()
        //尋找 ListView
        listView = findViewById<ListView>(R.id.listview)
        //設定 ListView 資料適配器
        listView?.adapter = myListAdapter
        //設定資料0筆時要顯示那個View(通常用TextView顯示 目前沒有資料)
        listView?.emptyView = findViewById<TextView>(R.id.empty)
        //設定(監聽器)點選項目OnItemClick要執行的程式
        listView?.setOnItemClickListener { parent, view, position, id ->
            r2Selected = myListAdapter?.stArrayList?.get(position)
            //監聽被點擊目標
            //根據被點擊的位置回傳position 從 adapter 取得資料傳給 r2
            val r2 = listView?.adapter?.getItem(position)

            //顯示資料
            val s = "position=" + position + " " + r2.toString()
            Log.d("@@@", s)

        }
    }

    //按鍵功能
    fun click_add(v: View) {
        //圖片陣列 新增 p04 圖片id
        myListAdapter?.drawableArrayList?.add(R.drawable.p04)
        //學生陣列 新增Mary
        val r2 = Result2("Mary", 87, 67)
        myListAdapter?.stArrayList?.add(r2)
        //資料有異動,通知ListView畫面需要更新
        myListAdapter?.notifyDataSetChanged()
        //顯示 短訊息
        Toast.makeText(context, "資料新增完成", Toast.LENGTH_SHORT).show()
    }

    //click_remove chatgpt產生
    fun click_remove(v: View) {
        // 檢查是否有選擇資料項目
        if (r2Selected != null) {
            // 檢查列表中是否有資料
            if (myListAdapter?.drawableArrayList?.isNotEmpty() == true && myListAdapter?.stArrayList?.isNotEmpty() == true) {
                // 確定被選中的資料項目在列表中的索引位置
                val position = myListAdapter?.stArrayList?.indexOf(r2Selected)

                // 移除被選中的 r2 變量
                myListAdapter?.stArrayList?.remove(r2Selected)
                myListAdapter?.drawableArrayList?.removeAt(position ?: -1)

                // 通知 ListView 更新畫面
                myListAdapter?.notifyDataSetChanged()

                // 顯示短訊息
                Toast.makeText(context, "資料移除完成", Toast.LENGTH_SHORT).show()
            } else {
                // 列表中無資料，顯示相應的提示訊息
                Toast.makeText(context, "沒有要移除的資料", Toast.LENGTH_SHORT).show()
            }

            // 清除選擇的 r2 變量
            r2Selected = null
        } else {
            // 沒有選擇資料項目，顯示相應的提示訊息
            Toast.makeText(context, "請先選擇要移除的資料項目", Toast.LENGTH_SHORT).show()
        }
    }

    fun click_reset(v: View) {
        初始化ListView()
        Toast.makeText(context, "資料reset", Toast.LENGTH_SHORT).show()
    }

    //inner 內部類別 可使用外部類別資料,包含private資料
    inner class MyListAdapter : BaseAdapter() { //繼承BaseAdapter
        //圖片陣列:arrayListOf() 快速建立ArrayList資料
        val drawableArrayList = arrayListOf<Int>(
            R.drawable.p01,
            R.drawable.p02,
            R.drawable.p03,
        )

        //學生陣列: arrayListOf() 快速建立ArrayList資料
        val stArrayList = arrayListOf<Result2>(
            Result2("Tom", 87, 96),
            Result2("Lisa", 75, 68),
            Result2("John", 90, 94),
        )

        //資料數量(由ListView呼叫 也稱為Callback函式)
        override fun getCount(): Int {
            return stArrayList.size //陣列大小 即 資料數量
        }

        //取得某項目資料(學生)(由ListView 呼叫 也稱為Callback函式)
        override fun getItem(position: Int): Any {
            val r2 = stArrayList.get(position)
            return r2
        }

        //取得某項目編號(由ListView 呼叫 也稱為Callback函式)
        override fun getItemId(position: Int): Long {
            val itemId = position + 0L
            return itemId
        }

        //取得某項目用的layout(由ListView 呼叫 也稱為Callback函式)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //載入Layout
            val itemLayout = context.layoutInflater.inflate(R.layout.item_layout, null)
            //尋找Layout 裡面 View
            val iv_image = itemLayout.findViewById<ImageView>(R.id.iv_item_image)
            val tv_item_n = itemLayout.findViewById<TextView>(R.id.tv_item_n)
            val tv_item_e = itemLayout.findViewById<TextView>(R.id.tv_item_e)
            val tv_item_m = itemLayout.findViewById<TextView>(R.id.tv_item_m)
            //顯示資料
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