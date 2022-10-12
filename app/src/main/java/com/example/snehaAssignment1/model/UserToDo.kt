package com.example.snehaAssignment1.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserToDo(

    @SerializedName("id")
    var id: Int,

    @SerializedName("userId")
    var userId: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("completed")
    var completed: String

):Serializable
