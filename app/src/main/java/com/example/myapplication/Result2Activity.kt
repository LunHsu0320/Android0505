package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.view.View
import android.util.Log
const val KEY_r2 = "KEY_Result2"

class Result2Activity : AppCompatActivity() {

    var ed_name: EditText? = null
    var ed_eng: EditText? = null
    var ed_math: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)
        設定初值()
    }

    private fun 設定初值() {
        ed_name = findViewById(R.id.ed_name)
        ed_eng = findViewById(R.id.ed_eng)
        ed_math = findViewById(R.id.ed_math)
    }

    fun btn_submit(view: View) {
        var n = ed_name?.text.toString()
        var e = ed_eng?.text.toString().toInt()
        var m = ed_math?.text.toString().toInt()

        var r2 = Result2(n, e, m)

        Log.d("@@@ 寄結果", r2.toString())

        val intent = getIntent()
        intent.putExtra(KEY_r2, r2)

        setResult(RESULT_OK, intent)
        finish()
    }


}