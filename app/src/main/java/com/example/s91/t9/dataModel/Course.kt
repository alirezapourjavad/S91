package com.example.s91.t9.dataModel

data class Course(var courseName: String,
) {
    val id = courseId

    companion object {
        var courseId = 100

    }

    init {
        courseId++
    }

    override fun toString(): String {
        return "$id : $courseName"
    }

}