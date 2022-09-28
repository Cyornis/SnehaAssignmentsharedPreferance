package com.example.snehaAssignment1.repositories

import android.app.Application
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.model.UserDetailsList

class UserListRepo(private val app: Application) {
  val list = ArrayList<UserDetails>()
  val listTwo = ArrayList<UserDetailsList>()


}