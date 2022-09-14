package com.example.snehaAssignment1.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.snehaAssignment1.interfaces.UserDao
import com.example.snehaAssignment1.model.UserDetails

@Database(entities = [UserDetails::class], version = 1)

abstract class UserDatabase : RoomDatabase(){
      abstract fun userDao(): UserDao

      companion object{
            private var instance: UserDatabase? = null

            @Synchronized
            fun getInstance(ctx: Context): UserDatabase?{
                if (instance == null)
                      instance = Room.databaseBuilder(ctx.applicationContext,
                      UserDatabase::class.java,
                      "User_Authorisation.db")
                            .fallbackToDestructiveMigration()
                            .build()

                  return instance
            }
      }
}