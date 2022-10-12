package com.example.snehaAssignment1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserDetailsBinding
import com.example.snehaAssignment1.interfaces.ItemClickListener
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.model.UserDetailsList
import com.example.snehaAssignment1.viewModel.UserDetailsViewModel
import com.example.snehaAssignment1.viewModel.UserListViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDetailsFragment : Fragment() {

    lateinit var binding: FragmentUserDetailsBinding
    private val userDetailsViewModel: UserDetailsViewModel by viewModels()

    init {
        lifecycleScope.launchWhenCreated {

            userDetailsViewModel.userToDoFlow.collect {

                when (it.clickEvent) {

                    ClickEvent.Nothing -> {
                        if (it.error) {
                            showToast(it.message ?: "")
                        }
                    }
                    ClickEvent.UserToDoClick -> {
                        openUserToDoFragment()
                    }

                    ClickEvent.UserPostClick ->{
                        openUserPostFragment()
                    }
                }
            }
        }
    }

    private fun openUserPostFragment() {
        val userPostFragment = UserPostFragment()
        val userPostFragmentObject = requireActivity().supportFragmentManager.beginTransaction()
        userPostFragmentObject.add(R.id.fragment_container_view_of_Home_activity,userPostFragment)
        userPostFragmentObject.addToBackStack(UserDetailsFragment::class.java.simpleName)
        userPostFragmentObject.commit()
    }

    private fun openUserToDoFragment() {
        val userToDoFragment = UserToDoFragment()
        val userToDoFragmentObject = requireActivity().supportFragmentManager.beginTransaction()
        userToDoFragmentObject.add(R.id.fragment_container_view_of_Home_activity, userToDoFragment)
        userToDoFragmentObject.addToBackStack(UserDetailsFragment::class.java.simpleName)
        userToDoFragmentObject.commit()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = userDetailsViewModel
        val data:UserDetailsList = arguments?.getSerializable("UserData") as UserDetailsList
        binding.nameComingFromUserListFragment.text = data.name
        binding.idComingFromUserListFragment.text = data.id.toString()
        binding.phoneComingFromUserListFragment.text = data.phone
        binding.emailComingFromUserListFragment.text = data.email
        binding.websiteComingFromUserListFragment.text = data.website
    }
}