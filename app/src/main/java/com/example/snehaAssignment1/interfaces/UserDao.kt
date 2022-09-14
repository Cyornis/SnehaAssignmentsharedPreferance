package com.example.snehaAssignment1.interfaces

import androidx.room.*
import com.example.snehaAssignment1.model.UserDetails

@Dao
interface UserDao {

    @Insert
    fun addUser(userDetails: UserDetails)

    @Update
    fun updateUser(userDetails: UserDetails)

    @Query("SELECT * FROM User_Authorisation WHERE email LIKE :email AND password LIKE :password LIMIT 1")
    fun getAllData(email:String, password:String):UserDetails?

    @Query("SELECT * FROM User_Authorisation WHERE email LIKE :email LIMIT 1")
    fun checkUserExists(email:String):UserDetails?

    @Delete
    fun deleteData(userDetails: UserDetails)

}

//ToDo insert,update,query,delete