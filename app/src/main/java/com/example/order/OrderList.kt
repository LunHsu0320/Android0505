package com.example.order

import java.io.Serializable

class OrderList:Serializable {
    private val serialVersionUID =1L//L 即 long 長整數
    var 漢堡數量 = ""
    var 薯條數量 = ""
    var 總金額 = ""

    constructor(漢堡數量:String,薯條數量:String,總金額:String){
        this.漢堡數量 = 漢堡數量
        this.薯條數量 = 薯條數量
        this.總金額 = 總金額
    }
    override fun toString():String{
        return "Student(漢堡數量='$漢堡數量',薯條數量='$薯條數量',總金額='$總金額')"
    }
}