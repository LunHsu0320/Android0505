package com.example.storeactivity

import java.io.Serializable

class Student:Serializable {
    private val serialVersionUID =1L//L 即 long 長整數
    var name = "未命名"
    var eng = -1
    var math = -1

    constructor(name:String,eng:Int,math:Int){
        this.name = name
        this.eng = eng
        this.math = math
    }
    override fun toString():String{
        return "Student(name='$name',eng=$eng,math=$math)"
    }
}