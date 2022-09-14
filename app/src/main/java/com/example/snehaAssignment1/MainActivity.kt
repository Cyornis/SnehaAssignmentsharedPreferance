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