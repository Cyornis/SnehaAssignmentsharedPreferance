package com.example.snehaAssignment1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.fragment.UserToDoFragment
import com.example.snehaAssignment1.interfaces.ItemClickListener
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.model.UserDetailsList
import com.example.snehaAssignment1.model.UserToDoEventModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class UserDetailsViewModel(val app: Application):AndroidViewModel(app) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val userToDoEvent = MutableSharedFlow<UserToDoEventModel>()
   // private val userPostEvent = MutableSharedFlow<UserPostEventModel>()
    val userToDoFlow = userToDoEvent.asSharedFlow()
    lateinit var userData : UserDetailsList


    fun onClickUserToDoBtn(){
        defaultScope.launch {
            val userToDoEventModel = UserToDoEventModel(clickEvent = ClickEvent.UserToDoClick)
            userToDoEvent.emit(userToDoEventModel)
        }
    }

    fun onClickUserPostBtn(){
         defaultScope.launch {
             val userToDoEventModel =UserToDoEventModel(clickEvent = ClickEvent.UserPostClick)
             userToDoEvent.emit(userToDoEventModel)
         }
    }
}
