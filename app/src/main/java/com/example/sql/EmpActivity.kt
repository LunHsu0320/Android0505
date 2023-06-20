package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import android.content.ContentValues
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import android.util.Log
import android.view.View

class EmpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emp)
    }

    fun db_create() {
        val appContext = this
        val dbHelper = DBHelper(appContext)
        val db = dbHelper.writableDatabase
        try {
            db.execSQL(CREATE_TABLE_SQL)
            Log.d("@@@", "建立表格")
        } catch (e: SQLiteException) {
            val s = "例外" + e.toString()
            Log.d("@@@", s)
        } finally {
            //finally 無論例外是否發生 最後一定要執行的收尾工作
            db.close()
        }

    }

    fun db_drop() {
        val appContext = this
        val dbHelper = DBHelper(appContext)
        val db = dbHelper.writableDatabase
        try {
            db.execSQL(DROP_TABLE_SQL)
            Log.d("@@@", "刪除表格")
        } catch (e: SQLiteException) {
            val s = "例外 " + e.toString()
            Log.d("@@@", s)
        } finally {
            //finally 無論例外是否發生 最後一定要執行的收尾工作
            db.close()
        }
    }

    fun db_insert() {
        val appContext = this
        val dbHelper = DBHelper(appContext)
        val db = dbHelper.writableDatabase
        try {
            val emp = Emp(1, "Tom", 1000.0, "1980-01-01")
            val values = ContentValues().apply {
                put("empid", emp.empid)
                put("name", emp.name)
                put("salary", emp.salary)
                put("birth", emp.birth)
            }
            val newRowId = db?.insertOrThrow("emp", null, values)
            var s = "新增完成 newRowId " + newRowId
            Log.d("@@@", s)
        } catch (e: SQLiteConstraintException) {
            val s = "新增失敗 員工編號重複 " + e.toString()
            Log.d("@@@", s)
        } catch (e: SQLiteException) {
            val s = "例外 " + e.toString()
            Log.d("@@@", s)
        } finally {
            //finally 無論例外是否發生 最後一定要執行的收尾工作
            db.close()
        }
    }

    fun db_select() {
        val appContext = this
        val dbHelper = DBHelper(appContext)
        val db = dbHelper.readableDatabase

        //查詢結果包含哪些欄位SELECT empid, name, salary, birth
        val projection = arrayOf("empid", "name", "salary", "birth")

        //查詢條件 WHERE empid=1
        //val empid = 1
        //val selection = "empid=?"
        //val selectionArgs = arrayOf(""+empid)//將empid帶入?

        //查詢所有(不設條件)

        val selection = null
        val selectionArgs = null

        try {
            val cursor = db.query(
                "emp",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
            )
            var 筆數 = 0

            with(cursor) {
                while (moveToNext()) {
                    筆數 += 1
                    //因為有with(cursor)
                    //所以能簡化cursor
                    //本來應該寫成cursor.getLong(cursor.getColumnIndexOrThrow("empid"))
                    val empid = getLong(getColumnIndexOrThrow("empid"))
                    val name = getString(getColumnIndexOrThrow("name"))
                    val salary = getDouble(getColumnIndexOrThrow("salary"))
                    val birth = getString(getColumnIndexOrThrow("birth"))
                    //val s = ""+empid+" "+name+" "+salary+" "+birth
                    val s = "查到 ${empid}${name}${salary}${birth}"
                    Log.d("@@@", s)
                }
            }
            val s = "共查詢到 " + 筆數 + " 筆資料"
            Log.d("@@@", s)
            cursor.close()
        } catch (e: Exception) {
            val s = "例外 " + e.toString()
            Log.d("@@@", s)
        } finally {
            //finally 無論例外是否發生 最後一定要執行的收尾工作
            db.close()
        }
    }

    fun db_update() {
        val appContext = this
        val dbHelper = DBHelper(appContext)
        val db = dbHelper.writableDatabase

        try {
            val emp = Emp(1, "Jack", 2000.0, "1980-02-02")
            val values = ContentValues().apply {
                put("name", emp.name)
                put("salary", emp.salary)
                put("birth", emp.birth)
            }
            val whereClause = "empid=?"
            val whereArgs = arrayOf("" + emp.empid)
            val 修改筆數 = db?.update("emp", values, whereClause, whereArgs)
            val s = "修改筆數 " + 修改筆數
            Log.d("@@@", s)

        } catch (e: SQLiteException) {
            val s = "例外 " + e.toString()
            Log.d("@@@", s)
        } finally {
            //finally 無論例外是否發生 最後一定要執行的收尾工作
            db.close()
        }
    }

    fun db_delete() {
        val appContext = this
        val dbHelper = DBHelper(appContext)
        val db = dbHelper.writableDatabase

        try {
            val empid = 1
            val whereClause = "empid=?"
            val whereArgs = arrayOf("" + empid)
            val 刪除筆數 = db?.delete("emp", whereClause, whereArgs)
            val s = "刪除筆數 " + 刪除筆數
            Log.d("@@@", s)

        } catch (e: SQLiteException) {
            val s = "例外 " + e.toString()
            Log.d("@@@", s)
        } finally {
            //finally 無論例外是否發生 最後一定要執行的收尾工作
            db.close()
        }
    }

    fun clickCreate(view: View) {
        db_create()
    }

    fun clickDrop(view: View) {
        db_drop()
    }

    fun clickInsert(view: View) {
        db_insert()
    }

    fun clickSelect(view: View) {
        db_select()
    }

    fun clickUpdate(view: View) {
        db_update()
    }

    fun clickDelete(view: View) {
        db_delete()
    }

}