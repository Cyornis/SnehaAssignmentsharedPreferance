package com.example.snehaAssignment1

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.snehaAssignment1.databases.UserDatabase
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
                ///login or signUp fragment open or home activity
                //if shared preferance has value of email and password both
                //then intent to open home screen activity
                //else
                //intent to open loginOrSignUp activity

                     Intent(this@MainActivity, LoginOrSignUpActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
           }
        timer.start()

        //indexing operator?????????????
        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))[SignUpViewModel::class.java]
        viewModel.onSignUpClick()

     }
}