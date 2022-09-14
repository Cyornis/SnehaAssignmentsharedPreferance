package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.app.DatePickerDialog
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.fragment.LoginFragment
import com.example.snehaAssignment1.fragment.SignUpFragment
import com.example.snehaAssignment1.interfaces.UserDao
import com.example.snehaAssignment1.local.controller.UserDbController
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.repositories.SignUpRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class SignUpViewModel(private val app: Application) : AndroidViewModel(app) {
private val defaultScope = CoroutineScope(Dispatchers.Default)

         private val repo = SignUpRepo(app)  //connection between view model and repository

//         val observer = Observer<UserDetails>()
         fun onSignUpClick() {

            defaultScope.launch {
                val userDetails = UserDetails(1,"Anjali","anjali123@gmail.com","123","1234567897","13-01-1998")
                //if - else used to check user is akready exist or not
                val exists = repo.checkUserExists(userDetails.email)
               if (exists){
                   withContext(Dispatchers.Main){
                       Log.e("Anjali","User already exists")
                   }
               }
                else{
                   repo.insert(userDetails)
               }
            }
         }

        fun onLoginClick() {
            onCleared()

        }

       fun  onDOBClick(){

       }


}




