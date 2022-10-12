package com.example.snehaAssignment1.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.snehaAssignment1.databases.RetrofitHelper
import com.example.snehaAssignment1.interfaces.ApiInterface
import com.example.snehaAssignment1.model.UserToDo

class UserToDoViewModel(val app:Application):AndroidViewModel(app) {

    private val dataFromUserToDoDataClass = ArrayList<UserToDo>()

    suspend fun staticData(){
        val apiInterface= RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val response = apiInterface.getDetailsFromUserToDo()
        dataFromUserToDoDataClass.addAll(response.body()!!)
        Log.d("ANJALI","api_call")
    }


}