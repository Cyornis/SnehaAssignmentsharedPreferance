package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.view.LoginOrSignUpActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val app: Application) : AndroidViewModel(app) {
     private val defaultScope = CoroutineScope(Dispatchers.Default)
     private val signUpEvent = MutableSharedFlow<SignUpEventModel>()
     val signUpFlow = signUpEvent.asSharedFlow()

     fun  onLogOutClickBtn(){
        defaultScope.launch {
            val sp = app.getSharedPreferences("SaveLoginCredential", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.clear()
            editor.apply()
            Log.d("DELETED","LOGOUT")

            //emit
            backToLoginOrSignUpActivity()
        }
    }

    private fun backToLoginOrSignUpActivity(){
        defaultScope.launch {
            val signUpEventModel = SignUpEventModel(clickEvent = ClickEvent.LoginClick)
            signUpEvent.emit(signUpEventModel)
        }
    }
}