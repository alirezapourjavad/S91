package com.example.s91.t9

import java.lang.Exception

class WelcomePage {
    init {
        printMenu()
    }

     fun printMenu (){

        println("\n **********MENU**********")
        println("""
        1- STUDENTS MANAGEMENT
        2- TEACHERS MANAGEMENT
        3- EXIT
    """.trimIndent())
        try {

            println("please enter number :")
            val selectUser= readLine()
            when (selectUser?.toInt()?:3) {
                1 -> studentsManagement()
                2 -> teachersManagement()
                3 -> exit()
                else-> printMenu()
            }
        }catch (e:Exception){
            println("enter a valid number")
            printMenu()
        }
    }


    private fun studentsManagement() {
        StudentsManagementPage(this)

    }

    private fun teachersManagement() {
        TeachersManagementPage(this)

    }

    private fun exit() {
        println("bye bye")
    }

}