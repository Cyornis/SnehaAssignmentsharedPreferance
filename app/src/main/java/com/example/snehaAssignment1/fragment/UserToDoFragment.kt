package com.example.snehaAssignment1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserToDoBinding
import com.example.snehaAssignment1.viewModel.UserToDoViewModel

class UserToDoFragment : Fragment() {

    lateinit var  binding : FragmentUserToDoBinding
     private val userToDoViewModel : UserToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_to_do, container, false)
        return  binding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.vm = userToDoViewModel
    }
}