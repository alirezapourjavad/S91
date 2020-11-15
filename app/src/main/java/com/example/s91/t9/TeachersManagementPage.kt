package com.example.s91.t9

import com.example.s91.t9.dataModel.Course
import com.example.s91.t9.dataModel.Teacher
import com.example.s91.t9.db.courseList
import com.example.s91.t9.db.teacherList

class TeachersManagementPage (private val welcomePage: WelcomePage) {

    init {
        printTeachersManagement()
    }

    private fun printTeachersManagement() {
        println("********TEACHERS MANAGEMENT********")
        println(
            """
            1- ADD TEACHER
            2- EDIT TEACHER
            3- SELECT COURSE
            4- PRINT TEACHERS LIST
            5- RETURN MENU
            
        """.trimIndent()
        )
        println("please enter number :")
        try {


            val selectStudentMenu = readLine()?.toInt() ?: -1
            when (selectStudentMenu) {
                1 -> addTeacher()
                2 -> editTeacher()
                3 -> selectCourse()
                4 -> printTeachersList()
                5 -> returnMenu()
                else -> printTeachersManagement()
            }
        } catch (e: NumberFormatException) {
            println("please enter valid number")
            printTeachersManagement()
        }

    }

    private fun addTeacher() {
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

                var newTeacher = selectCourse()?.let { Teacher(name, familyname, pid, age, it) }
                if (newTeacher != null) {
                    teacherList.add(newTeacher)
                }
                if (newTeacher != null) {
                    println("new teacher added and id is ${newTeacher.id}")
                }
            }
        } catch (e: Exception) {
            println(" please enter all caracters")
            addTeacher()
        }
        printTeachersManagement()
    }

    private fun editTeacher() {
        println("\nplease enter teacher id :")
        var foundTeacher: Teacher?=null
        var teacherId = readLine()?.toInt()
        var serachflag = false
        for (tea in teacherList) {
            try {


                if (teacherId==tea.id) {
                    foundTeacher=tea
                    serachflag = true
                    foundTeacher.apply {
                        println("enter new name (${name})")
                        name = readLine()
                        println("enter new familyname (${familyName})")
                        familyName = readLine()
                        println("enter age ${age})")
                        age = readLine()?.toInt()
                        println("enter new pid ($pid)")
                        pid = readLine()?.toInt()

                    }
                    printTeachersManagement()
                }
            } catch (e: Exception) {
                println(" enter valid code ")
            }

        }



        if (!serachflag) {
            println("please enter valid id ")
            editTeacher()
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

    private fun printTeachersList() {
        println(teacherList)
        printTeachersManagement()
    }

    private fun returnMenu() {
        welcomePage.printMenu()
    }
}
