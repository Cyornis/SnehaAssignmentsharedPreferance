package com.example.snehaAssignment1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

    }
}