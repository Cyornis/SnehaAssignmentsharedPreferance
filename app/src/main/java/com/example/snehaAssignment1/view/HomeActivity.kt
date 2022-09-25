package com.example.snehaAssignment1.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.ActivityHomeBinding
import com.example.snehaAssignment1.fragment.HomeScreenFragment
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
            val logOutFragment = HomeScreenFragment()
            val logOutFragmentObject = supportFragmentManager.beginTransaction()
            logOutFragmentObject.replace(R.id.fragment_container_view_of_Home_activity,logOutFragment)
            logOutFragmentObject.commit()

    }
}