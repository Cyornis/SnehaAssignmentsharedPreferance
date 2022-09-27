package com.example.snehaAssignment1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.SignUpEventModel
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.model.UserListEventModel
import com.example.snehaAssignment1.repositories.UserListRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class UserListViewModel(val app: Application ):AndroidViewModel(app) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val userListEvent = MutableSharedFlow<UserListEventModel>()
    val userListFlow = userListEvent.asSharedFlow()

    val userListRepo = UserListRepo(app)
    val data = ArrayList<UserDetails>()
    val adapter = UserListAdapter(data)

    fun staticData(){

      for (i in 0 until 5){
          val userDetails = UserDetails(i,"Anjali$i","abc@gmail.com","123abcd@","123467891","12-10-1897")
          data.add(userDetails)

      }
        adapter.notifyDataSetChanged()
    }

}