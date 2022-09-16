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
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.repositories.SignUpRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class SignUpViewModel(private val app: Application) : AndroidViewModel(app) {
    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val signUpEvent = MutableSharedFlow<SignUpEventModel>()
    private val repo = SignUpRepo(app)  //connection between view model and repository
    private lateinit var userDetails: UserDetails

    val signUpFlow = signUpEvent.asSharedFlow()   //signUpFlow is used to provide data from SignUpViewModel to SignUpFragment
    var userName = ""
    var emailId = ""
    var mobileNumber = ""
    var password = ""

    fun onSignUpClick() {

        defaultScope.launch {
//two way binding is used

            if (userName.isBlank()) {
                withContext(Dispatchers.Main) {
                    // Log.e("Anjali", "User Name should not be blank")
                    val signUpEventModel = SignUpEventModel("Username shold not be blank")
                    signUpEvent.emit(signUpEventModel)  // here message is given to fragment
                }
            } else if (emailId.isBlank()) {
                withContext(Dispatchers.Main) {
//                        Log.e("Anjali", "EmailId should not be blank")
                    val signUpEventModel = SignUpEventModel("EmailId should not be blank")
                    signUpEvent.emit(signUpEventModel)
                }
            } else if (mobileNumber.isBlank()) {
                withContext(Dispatchers.Main) {
//                        Log.e("Anjali", "Mobile Number should not be blank")
                    val signUpEventModel = SignUpEventModel("Mobile Number should not be blank")
                    signUpEvent.emit(signUpEventModel)
                }
            } else if (password.isBlank()) {
                withContext(Dispatchers.Main) {
//                        Log.e("Anjali", "Password should not be blank")
                    val signUpEventModel = SignUpEventModel("Password should not be blank")
                    signUpEvent.emit(signUpEventModel)
                }
            } else {
                val userDetails =
                    UserDetails(1, userName, emailId, password, mobileNumber, "13-01-1998")
                val exists = repo.checkUserExists(userDetails.email)

                if (exists) {
                    withContext(Dispatchers.Main) {
//                            Log.e("Anjali", "User already exists")
                        val signUpEventModel = SignUpEventModel("User already exists")
                        signUpEvent.emit(signUpEventModel)
                    }
                } else {
                    repo.insert(userDetails)
                }

            }
        }

    }

    fun onLoginClick() {
        defaultScope.launch {
            val signUpEventModel = SignUpEventModel(clickEvent = ClickEvent.LoginTextClick)
            signUpEvent.emit(signUpEventModel)

        }
    }

    fun onDOBClick() {

    }

}





