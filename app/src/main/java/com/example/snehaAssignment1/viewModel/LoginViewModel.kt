package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.LoginEventModel
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.repositories.LoginRepo
import com.example.snehaAssignment1.repositories.SignUpRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(private val app: Application) : AndroidViewModel(app) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val loginEvent = MutableSharedFlow<LoginEventModel>()
    private val repo = LoginRepo(app)  //connection between view model and repository


    val loginFlow = loginEvent.asSharedFlow()

     var emailId = ""
    var password = ""

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"
    private val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"


    fun onLoginClick() {
        defaultScope.launch {

            when {
                emailId.isBlank() -> {
                    withContext(Dispatchers.Main) {
                        val loginEventModel =
                            LoginEventModel(app.getString(R.string.alert_email_should_not_be_blank))
                        loginEvent.emit(loginEventModel)
                    }
                }
                !emailId.matches(emailPattern.toRegex()) -> {
                    withContext(Dispatchers.Main) {
                        val loginEventModel =
                            LoginEventModel(app.getString(R.string.alert_enter_valid_emailId))
                        loginEvent.emit(loginEventModel)
                    }
                }
                password.isBlank() -> {
                    withContext(Dispatchers.Main) {
                        val loginEventModel =
                            LoginEventModel(app.getString(R.string.alert_password_should_not_be_blank))
                        loginEvent.emit(loginEventModel)
                    }
                }
                !password.matches(passwordPattern.toRegex()) -> {
                    withContext(Dispatchers.Main) {
                        val loginEventModel =
                            LoginEventModel(app.getString(R.string.alert_enter_valid_password))
                        loginEvent.emit(loginEventModel)
                    }
                }
                else -> {
                    val exists = repo.checkUserExistsLogin(emailId, password)
                    if (exists) {
                        withContext(Dispatchers.Main) {
                            val loginModel =
                                LoginEventModel(clickEvent = ClickEvent.LoginClick)
                            loginEvent.emit(loginModel)
                            saveLoginCredential(emailId, password)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            val loginModel =
                                LoginEventModel(app.getString(R.string.alert_email_and_password_do_not_match))
                            loginEvent.emit(loginModel)
                        }
                    }
                }
            }
        }
    }

    fun onSignUpClick() {

        defaultScope.launch {
            val loginModel = LoginEventModel(clickEvent = ClickEvent.SignUpTextClick)
            loginEvent.emit(loginModel)

        }
    }

    private fun saveLoginCredential(emailId:String,password:String){
        defaultScope.launch {
            val sp = app.getSharedPreferences("SaveLoginCredential",Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("SavedEmailId",emailId)
            editor.putString("SavedPassword",password)
            editor.putBoolean("isLoggedIn",true)


            editor.apply()
        }
    }
}
