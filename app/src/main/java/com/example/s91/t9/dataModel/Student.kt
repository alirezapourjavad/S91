package com.example.s91.t9.dataModel

data class Student(
    var name: String?,
    var familyName: String?,
    var pid: Int?,
    var age: Int?,
    var course: Course,
        ) {
    val id: Int = studentCounter

    companion object {
        var studentCounter = 1000
    }

    init {
        studentCounter++
    }

    override fun toString(): String {
        println(" ")
        return "\n ID = $id , $name ,$familyName , pid = $pid , age = $age , $course "
    }
}