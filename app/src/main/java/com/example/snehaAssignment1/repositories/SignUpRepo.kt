package com.example.snehaAssignment1.repositories

import android.app.Application
import android.os.Bundle
import com.example.snehaAssignment1.local.controller.UserDbController
import com.example.snehaAssignment1.model.UserDetails

class SignUpRepo(private  val app: Application ) {

    private val dbController = UserDbController(app) //connection with db

    suspend fun insert(userDetails: UserDetails) {
        dbController.insertUserData(userDetails)
    }

    suspend fun update(userDetails: UserDetails){
        dbController.updateUserData(userDetails)
    }

    suspend fun getData(userDetails: UserDetails){
        dbController.getData(userDetails)
    }

    suspend fun checkUserExists(email:String) = dbController.checkUserExists(email) /////smart casting

    suspend fun delete(userDetails: UserDetails){
        dbController.deleteUserData(userDetails)
    }
}

// private val netController = NetworkController(application)  // connection with network  (for API)