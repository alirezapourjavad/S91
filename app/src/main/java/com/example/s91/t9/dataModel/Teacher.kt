package com.example.s91.t9.dataModel

class Teacher (
    var name: String?,
    var familyName: String?,
    var pid: Int?,
    var age: Int?,
    var course: Course,
    ) {
        val id: Int = teacherCounter

        companion object {
            var teacherCounter = 2000
        }

        init {
            teacherCounter++
        }

        override fun toString(): String {
            println(" ")
            return "\n ID = $id , $name ,$familyName , pid = $pid , age = $age , $course "
        }
    }
