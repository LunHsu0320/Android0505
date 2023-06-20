package com.example.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME= "emp.db"
const val DATABASE_VERSION = 1
const val CREATE_TABLE_SQL="CREATE TABLE emp"+
        "("+
        "empid INTERGER PRIMARY KEY, " +
        "name TEXT, " +
        "salary REAL," +
        "birth TEXT" +
        ")"
const val DROP_TABLE_SQL = "DROP TABLE IF EXISTS emp"

class DBHelper(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION) {
    //第一次建立資料庫時，onCreate會被執行
    override fun onCreate(db:SQLiteDatabase?){
        db?.execSQL(CREATE_TABLE_SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_SQL)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}