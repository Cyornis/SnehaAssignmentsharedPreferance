package com.example.snehaAssignment1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.databases.RetrofitHelper
import com.example.snehaAssignment1.interfaces.ApiInterface
import com.example.snehaAssignment1.model.*
import com.example.snehaAssignment1.repositories.UserListRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import retrofit2.create

class UserListViewModel(val app: Application ):AndroidViewModel(app) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val userListEvent = MutableSharedFlow<UserListEventModel>()
    val userListFlow = userListEvent.asSharedFlow()

    val userListRepo = UserListRepo(app)
    val data = ArrayList<UserDetailsList>()
    val adapter = UserListAdapter(data)

    private val userDetailsList = UserDetailsList(1, "Anjali","abc@gmail.com")

    suspend fun staticData(){

        val apiInterface=RetrofitHelper.getInstance().create(ApiInterface::class.java)
//      apiInterface.getDetails(1)
        apiInterface.getDetails(userDetailsList.id)
        apiInterface.postData(userDetailsList)

//      for (i in 0 until 5){
//          val userDetails = UserDetails(i,"Anjali$i","abc@gmail.com","123abcd@","123467891","12-10-1897")
//          data.add(userDetails)
//      }

        adapter.notifyDataSetChanged()
    }

}