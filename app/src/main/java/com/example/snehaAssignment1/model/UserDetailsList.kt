package com.example.snehaAssignment1.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserDetailsList(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name:String,

    @SerializedName("email")
    var email:String,

    @SerializedName("phone")
    var phone:String,

    @SerializedName("website")
    var website:String


):Serializable
