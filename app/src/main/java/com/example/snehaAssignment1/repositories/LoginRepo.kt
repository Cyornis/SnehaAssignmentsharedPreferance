package com.example.snehaAssignment1.repositories

import android.app.Application
import com.example.snehaAssignment1.local.controller.UserDbController
import com.example.snehaAssignment1.remote.controller.NetworkController

class LoginRepo(private val application: Application) {

    private val dbController =  UserDbController(application)
    private val networkController =  NetworkController(application)
}