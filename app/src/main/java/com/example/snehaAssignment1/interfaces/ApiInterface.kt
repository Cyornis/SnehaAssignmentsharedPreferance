package com.example.snehaAssignment1.interfaces

import com.example.snehaAssignment1.model.UserDetailsList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
    suspend fun getDetails(@Query("id") id:Int): Response<UserDetailsList>

    @POST("users")
    fun postData(@Body userDetailsList: UserDetailsList): Call<UserDetailsList>
}