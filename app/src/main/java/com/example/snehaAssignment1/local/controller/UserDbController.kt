package com.example.snehaAssignment1.local.controller

import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import com.example.snehaAssignment1.databases.UserDatabase
import com.example.snehaAssignment1.interfaces.UserDao
import com.example.snehaAssignment1.model.UserDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class UserDbController(private  val application: Context):CoroutineScope {

   suspend fun insertUserData(userDetails: UserDetails){
       withContext(coroutineContext){
           UserDatabase.getInstance(application)?.userDao()?.addUser(userDetails)
       }
   }

    suspend fun updateUserData(userDetails: UserDetails){
        withContext(coroutineContext){
            UserDatabase.getInstance(application)?.userDao()?.updateUser(userDetails)
        }
    }

    suspend fun getData(userDetails: UserDetails){
        withContext(coroutineContext){
            UserDatabase.getInstance(application)?.userDao()?.getAllData(userDetails.email,userDetails.password)
        }
    }

    suspend fun checkUserExists(email:String):Boolean{
      return  withContext(coroutineContext){
          val userDetails =
            UserDatabase.getInstance(application)?.userDao()?.checkUserExists(email)
          userDetails?.let {
              true
          }?:kotlin.run{
              false
          }
        }
    }

    suspend fun deleteUserData(userDetails: UserDetails){
        withContext(coroutineContext){
            UserDatabase.getInstance(application)?.userDao()?.deleteData(userDetails)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}