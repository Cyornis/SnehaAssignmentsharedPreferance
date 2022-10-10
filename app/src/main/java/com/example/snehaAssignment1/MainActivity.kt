package com.example.snehaAssignment1

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.snehaAssignment1.databases.UserDatabase
import com.example.snehaAssignment1.view.HomeActivity
import com.example.snehaAssignment1.view.LoginOrSignUpActivity
import com.example.snehaAssignment1.viewModel.SignUpViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timer = object : CountDownTimer(2000,1000){

            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {

                     defaultLogin()
                }
           }
        timer.start()

        //indexing operator?????????????
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))[SignUpViewModel::class.java]
        viewModel.onSignUpClick()

     }
    fun defaultLogin(){

        val sp = getSharedPreferences("SaveLoginCredential",Context.MODE_PRIVATE)
        val emailId = sp.getString("SavedEmailId",null)
        val password = sp.getString("SavedPassword",null)

        if (!emailId.isNullOrEmpty() && !password.isNullOrEmpty()){
            Log.d("ANJALI","User Logged In")
            Log.d("ANJALI",emailId.toString())
            Log.d("ANJALI",password.toString())

            Intent(this@MainActivity, HomeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        else{
            Intent(this@MainActivity, LoginOrSignUpActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}