package com.example.snehaAssignment1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserPostBinding
import com.example.snehaAssignment1.viewModel.UserPostViewModel

class UserPostFragment : Fragment() {

    lateinit var binding : FragmentUserPostBinding
    val userPostViewModel : UserPostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_post, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = userPostViewModel

    }
}