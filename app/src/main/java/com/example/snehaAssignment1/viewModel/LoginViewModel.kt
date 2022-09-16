package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.LoginEventModel
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.repositories.LoginRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val loginEvent = MutableSharedFlow<LoginEventModel>()
    val loginFlow = loginEvent.asSharedFlow()
    lateinit var userDetails: UserDetails
    private val repo=LoginRepo(application)
    private val emailId = ""
    private val password = ""


    fun onLoginClick() {
        defaultScope.launch {

            if (emailId.isBlank()) {
                withContext(Dispatchers.Main) {
//                        Log.e("Anjali", "EmailId should not be blank")
                    val loginEventModel = LoginEventModel("EmailId should not be blank")
                    loginEvent.emit(loginEventModel)

                }
            }
            else if(password.isBlank()){
                withContext(Dispatchers.Main){
                    val loginEventModel = LoginEventModel("Password should not be blank")
                    loginEvent.emit(loginEventModel)
                }
            }
            else{
                val exists = repo.checkUserExistsLogin(userDetails.email,userDetails.password)
                if (exists) {
                    withContext(Dispatchers.Main) {
//                            Log.e("Anjali", "User already exists")
                        val loginModel = LoginEventModel("User already exists")
                        loginEvent.emit(loginModel)
                    }
                }

                else{
                    withContext(Dispatchers.Main) {
//                            Log.e("Anjali", "User already exists")
                        val loginModel = LoginEventModel("Require SignIn")
                        loginEvent.emit(loginModel)
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
}
