package com.example.snehaAssignment1.repositories

import android.app.Application
import com.example.snehaAssignment1.local.controller.UserDbController
import com.example.snehaAssignment1.model.UserDetails

class SignUpRepo(private  val app: Application ) {

    private val dbController = UserDbController(app) //connection with db


    suspend fun onCreate(){
        dbController.insertUserData()
    }
   // private val netController = NetworkController(application)  // connection with network  (for API)

}