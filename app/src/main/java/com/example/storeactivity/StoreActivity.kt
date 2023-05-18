package com.example.storeactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import android.util.Log
import android.view.View
import android.widget.EditText


class StoreActivity : AppCompatActivity() {

    private val filename = "st.ser"
    private var st: Student? = null
    var ed_name: EditText? = null
    var ed_eng: EditText? = null
    var ed_math: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
    }
    private fun 設定初值() {
        //findViewById 這邊對應 xml 所以那邊要加id
        ed_name = findViewById(R.id.et_name)
        ed_eng = findViewById(R.id.et_eng)
        ed_math = findViewById(R.id.et_math)
    }
    private fun 建立學生物件() {

        var n = ed_name?.text.toString()
        var e = ed_eng?.text.toString().toInt()
        var m = ed_math?.text.toString().toInt()

        st = Student(n, e, m)
        Log.d("@@@", st.toString())
    }

    private fun 存檔() {
        try {
            val fos = openFileOutput(filename, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(st)
            oos.close()
            fos.close()
            Log.d("@@@", "存檔成功")
            //顯示訊息 存檔成功
            //訊息停留時間
            //LENGTH_LONG 長
            //LENGTH_SHORT 短
            Toast.makeText(this, "存檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Log.d("@@@ 檔案找不到", e.toString())
        } catch (e: IOException) {
            Log.d("@@@ 輸出發生問題", e.toString())
        }
    }

    fun btn_save(view: View) {
        設定初值()
        建立學生物件()
        存檔()
    }

    private fun 讀檔() {
        try {
            val fis = openFileInput(filename)
            val ois = ObjectInputStream(fis)
            st = ois.readObject() as Student? // as Student? 轉型
            ois.close()
            fis.close()
            Log.d("@@@", "讀檔成功" + st.toString())
            //顯示訊息 存檔成功
            //訊息停留時間
            //LENGTH_LONG 長
            //LENGTH_SHORT 短
            Toast.makeText(this, "讀檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Log.d("@@@ 檔案找不到", e.toString())
        } catch (e: IOException) {
            Log.d("@@@ 輸出發生問題", e.toString())
        }
    }

    private fun 顯示() {
        val tv_name = findViewById<EditText>(R.id.et_name)
        val tv_eng = findViewById<EditText>(R.id.et_eng)
        val tv_math = findViewById<EditText>(R.id.et_math)
        tv_name.setText(st?.name)
        tv_eng.setText("" + st?.eng)
        tv_math.setText("" + st?.math)
    }

    fun btn_load(view: View) {
        讀檔()
        顯示()
    }

    fun btn_clear(view:View){
        val tv_name = findViewById<EditText>(R.id.et_name)
        val tv_eng = findViewById<EditText>(R.id.et_eng)
        val tv_math = findViewById<EditText>(R.id.et_math)
        tv_name.setText("")
        tv_eng.setText("")
        tv_math.setText("")
    }

}
