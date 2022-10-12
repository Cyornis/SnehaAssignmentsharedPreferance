package com.example.snehaAssignment1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.model.UserPost

class UserPostViewModel(val app:Application) : AndroidViewModel(app){

    val dataFromUserPostDataClass = ArrayList<UserPost>()
}