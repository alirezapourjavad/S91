package com.example.s91.t9

import com.example.s91.t9.dataModel.Course
import com.example.s91.t9.dataModel.Student
import com.example.s91.t9.db.courseList
import com.example.s91.t9.db.courseList
import com.example.s91.t9.db.studentList

class StudentsManagementPage(private val welcomePage: WelcomePage) {

    init {
        printStudentsManagement()
    }

    private fun printStudentsManagement() {
        println("********STUDENTSMANAGEMENT********")
        println(
            """
            1- ADD STUDENT
            2- EDIT STUDENT
            3- SELECT COURSE
            4- PRINT STUDENTS LIST
            5- RETURN MENU
            
        """.trimIndent()
        )
        println("please enter number :")
        try {


            val selectStudentMenu = readLine()?.toInt() ?: -1
            when (selectStudentMenu) {
                1 -> addStudent()
                2 -> editStudent()
                3 -> selectCourse()
                4 -> printStudentsList()
                5 -> returnMenu()
                else -> printStudentsManagement()
            }
        } catch (e: NumberFormatException) {
            println("please enter valid number")
            printStudentsManagement()
        }

    }

    private fun addStudent() {
        try {
            println("please enter name :")
            var name = readLine()
            println("please enter family name :")
            var familyname = readLine()
            println("please enter age :")
            var age = readLine()?.toInt()
            println("please enter pid :")
            var pid = readLine()?.toInt()


            if (name != null && familyname != null && age != null && pid != null) {

                var newStudent = selectCourse()?.let { Student(name, familyname, pid, age, it) }
                if (newStudent != null) {
                    studentList.add(newStudent)
                }
                if (newStudent != null) {
                    println("new student added and id is ${newStudent.id}")
                }
            }
        } catch (e: Exception) {
            println(" please enter all caracters")
            addStudent()
        }
        printStudentsManagement()
    }

    private fun editStudent() {
        println("\nplease enter student id :")
        var foundStudent:Student ?=null
        var studentId = readLine()?.toInt()
        var serachflag = false
        for (stu in studentList) {
            try {


                if (studentId==stu.id) {
                    foundStudent=stu
                    serachflag = true
                    foundStudent.apply {
                        println("enter new name (${name})")
                        name = readLine()
                        println("enter new familyname (${familyName})")
                        familyName = readLine()
                        println("enter age ${age})")
                        age = readLine()?.toInt()
                        println("enter new pid ($pid)")
                        pid = readLine()?.toInt()

                    }
                    printStudentsManagement()
                }
            } catch (e: Exception) {
                println(" enter valid code ")
            }

        }



        if (!serachflag) {
            println("please enter valid id ")
            editStudent()
        }


    }

    fun selectCourse(): Course? {
        for (course in courseList) {
            println(course)
        }
        println("please enter code :")
        val id = readLine()?.toInt()
        var flag = false
        var foundCourse: Course? = null
        for (course in courseList) {
            if (course.id == id) {
                foundCourse = course
                flag = true
                break

            }
        }
        if (!flag) {
            println(" course not found")
        }

        return foundCourse


    }

    private fun printStudentsList() {
        println(studentList)
        printStudentsManagement()
    }

    private fun returnMenu() {
       welcomePage.printMenu()
    }
}