package com.example.snehaAssignment1.interfaces

import com.example.snehaAssignment1.model.UserDetailsList

interface ItemClickListener {
   fun onItemClickListener(position:Int,userDetailsList: UserDetailsList)
}