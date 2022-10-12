package com.example.snehaAssignment1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserToDoBinding
import com.example.snehaAssignment1.model.UserToDo
import com.example.snehaAssignment1.viewModel.UserToDoViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserToDoFragment : Fragment() {

     lateinit var  binding : FragmentUserToDoBinding
     private val userToDoViewModel : UserToDoViewModel by viewModels()
     //  private val user= UserToDo(userId = 1, id = 1, title = "sdfghjk",completed="true")

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

        GlobalScope.launch {
            userToDoViewModel.staticData()
            Log.d("Anjali","GetUserToDoDetails")

            activity?.runOnUiThread(Runnable{
                userToDoViewModel.adapter.notifyDataSetChanged()
//                binding.UserID.text = userToDoViewModel.dataFromUserToDoDataClass[0].userId.toString()
//                binding.ID.text = userToDoViewModel.dataFromUserToDoDataClass[0].id.toString()
//                binding.title.text = userToDoViewModel.dataFromUserToDoDataClass[0].title
//                binding.completed.text = userToDoViewModel.dataFromUserToDoDataClass[0].completed
            })
        }
    }
}