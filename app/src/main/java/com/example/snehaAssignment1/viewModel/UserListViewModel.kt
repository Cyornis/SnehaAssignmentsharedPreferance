package com.example.snehaAssignment1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.SignUpEventModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class UserListViewModel(val app: Application ):AndroidViewModel(app) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val signUpEvent = MutableSharedFlow<SignUpEventModel>()
    val signUpFlow = signUpEvent.asSharedFlow()




}