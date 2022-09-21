package com.example.snehaAssignment1.view

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.fragment.LoginFragment
import com.example.snehaAssignment1.fragment.SignUpFragment
import java.text.SimpleDateFormat
import java.util.*

class LoginOrSignUpActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_loginorsignup)

        openFragment()
//        onBackPressedDispatcher.onBackPressed()
    }
    private fun openFragment() {
        val loginFragment = LoginFragment()
        val loginFragmentObject = supportFragmentManager.beginTransaction()
        loginFragmentObject.replace(R.id.fragment_container_view,loginFragment)
        loginFragmentObject.commit()
    }
}