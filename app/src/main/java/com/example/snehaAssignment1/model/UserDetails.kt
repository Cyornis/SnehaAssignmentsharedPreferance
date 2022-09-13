package com.example.snehaAssignment1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User_Authorisation")
data class UserDetails(

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo
    var name: String,

    @ColumnInfo
    var email :String,

    @ColumnInfo
    var password: String,

    @ColumnInfo
    var phone_number: String,

    @ColumnInfo
    var dob: String

    ):Serializable
