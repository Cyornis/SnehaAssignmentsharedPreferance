package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.databases.RetrofitHelper
import com.example.snehaAssignment1.fragment.UserDetailsFragment
import com.example.snehaAssignment1.interfaces.ApiInterface
import com.example.snehaAssignment1.interfaces.ItemClickListener
import com.example.snehaAssignment1.model.*
import com.example.snehaAssignment1.repositories.UserListRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


class UserListViewModel(val app: Application ):AndroidViewModel(app) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)
    private val userListEvent = MutableSharedFlow<UserListEventModel>()
    val userListFlow = userListEvent.asSharedFlow()
    val userListRepo = UserListRepo(app)
    var data =ArrayList<UserDetailsList>()
    val adapter = UserListAdapter(data)

    //private val userDetailsList = UserDetailsList(1, "Anjali","abc@gmail.com")

    suspend fun staticData(){
        val apiInterface=RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val response = apiInterface.getData()
        data.addAll(response.body()!!)
        Log.d("ANJALI","api_call")

     //   adapter.notifyDataSetChanged()
    }

    fun testFunction( itemClickListener: ItemClickListener){
        adapter.testFunct(itemClickListener)
    }

}