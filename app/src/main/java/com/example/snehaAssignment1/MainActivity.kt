package com.example.snehaAssignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.snehaAssignment1.view.LoginOrSignUpActivity

class MainActivity : AppCompatActivity() {

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
     }
}