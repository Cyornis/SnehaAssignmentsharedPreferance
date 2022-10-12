package com.example.snehaAssignment1.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserPost(

    @SerializedName("userId")
    var userId:Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("body")
    var body: String

):Serializable
