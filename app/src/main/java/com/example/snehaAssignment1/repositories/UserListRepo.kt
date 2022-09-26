package com.example.snehaAssignment1.repositories

import android.app.Application
import com.example.snehaAssignment1.model.UserListDetails

class UserListRepo(private val app: Application) {
 private val list = ArrayList<UserListDetails>()
}