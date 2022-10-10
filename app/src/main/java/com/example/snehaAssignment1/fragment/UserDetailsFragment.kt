package com.example.snehaAssignment1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserDetailsBinding
import com.example.snehaAssignment1.viewModel.UserDetailsViewModel
import com.example.snehaAssignment1.viewModel.UserListViewModel

class UserDetailsFragment : Fragment() {

    lateinit var binding : FragmentUserDetailsBinding
    private val userDetailsViewModel : UserDetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_user_details, container, false)
        return binding.root
    }

     fun onViewCreated(){
        binding.vm = userDetailsViewModel
    }
}