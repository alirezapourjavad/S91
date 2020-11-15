package com.example.s91.t9.db

import com.example.s91.t9.dataModel.Course
import com.example.s91.t9.dataModel.Student
import com.example.s91.t9.dataModel.Teacher


val courseList= mutableListOf<Course>(
        Course("RIAZI"),
        Course("ADABIAT"),
        Course("JABR"),
        Course("VARZESH")

    )
var studentList = mutableListOf<Student>(
    Student("alireza","pourjavad",345567,30,Course("RIAZI")),
    Student("hamidreza","pourjavad",65438,30,Course("VARZESH"))


)
var teacherList= mutableListOf<Teacher>(
    Teacher("farzad","hoseini",654739,38,Course("JABR"))
)
