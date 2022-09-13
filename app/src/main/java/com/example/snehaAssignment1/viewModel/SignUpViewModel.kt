package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.app.DatePickerDialog
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.snehaAssignment1.fragment.LoginFragment
import com.example.snehaAssignment1.fragment.SignUpFragment
import com.example.snehaAssignment1.interfaces.UserDao
import com.example.snehaAssignment1.local.controller.UserDbController
import com.example.snehaAssignment1.repositories.SignUpRepo
import java.text.SimpleDateFormat
import java.util.*


class SignUpViewModel(private val app: Application) : AndroidViewModel(app) {
    private val repo = SignUpRepo(app)  //connection between view model and repository

    fun onSignUpClick() {
        repo.
    }

   fun onLoginClick(){
       onCleared()
   }

}



