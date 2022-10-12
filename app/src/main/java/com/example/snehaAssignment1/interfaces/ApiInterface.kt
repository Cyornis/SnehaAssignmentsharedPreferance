package com.example.snehaAssignment1.interfaces

import com.example.snehaAssignment1.model.UserDetailsList
import com.example.snehaAssignment1.model.UserDetailsResponse
import com.example.snehaAssignment1.model.UserToDo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    suspend fun getDetails(): Response<UserDetailsList>

    @GET("users")
    suspend fun getData():Response<ArrayList<UserDetailsList>>

    @GET("todos")
    suspend fun getDetailsFromUserToDo(): Response<ArrayList<UserToDo>>

    @POST("users")
    fun postData(@Body userDetailsList: UserDetailsList): Call<UserDetailsList>
}