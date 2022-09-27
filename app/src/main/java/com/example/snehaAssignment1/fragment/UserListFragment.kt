package com.example.snehaAssignment1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserListBinding
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.UserListDetails
import com.example.snehaAssignment1.viewModel.UserListAdapter
import com.example.snehaAssignment1.viewModel.UserListViewModel

class UserListFragment : Fragment() {

    private val userListViewModel : UserListViewModel by viewModels()
    private lateinit var binding  : FragmentUserListBinding

    init {
        lifecycleScope.launchWhenCreated {
           userListViewModel.userListFlow.collect{
               Toast.makeText(requireContext(),"Anjali",Toast.LENGTH_SHORT).show()

           }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = userListViewModel
        val data = ArrayList<UserListDetails>()
        val rv = binding.userListRecyclerView
        val adapter = UserListAdapter(data)
        rv.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        rv.adapter = adapter
    }
}