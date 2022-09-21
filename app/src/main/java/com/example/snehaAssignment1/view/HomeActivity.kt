package com.example.snehaAssignment1.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.ActivityHomeBinding
import com.example.snehaAssignment1.fragment.LogOutFragment
import com.example.snehaAssignment1.fragment.LoginFragment
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.viewModel.HomeViewModel

class HomeActivity: AppCompatActivity() {

lateinit var binding : ActivityHomeBinding
private val  homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.vm = homeViewModel

        logOutFragment()

        //collect from homeview model (intent)

    }

    private fun  logOutFragment(){
            val logOutFragment = LogOutFragment()
            val logOutFragmentObject = supportFragmentManager.beginTransaction()
            logOutFragmentObject.replace(R.id.fragment_container_view_of_Home_activity,logOutFragment)
            logOutFragmentObject.commit()

    }
}