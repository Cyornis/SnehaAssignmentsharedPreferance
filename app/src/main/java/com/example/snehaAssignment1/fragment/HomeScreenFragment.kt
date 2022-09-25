package com.example.snehaAssignment1.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentHomeScreenBinding
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.view.LoginOrSignUpActivity
import com.example.snehaAssignment1.viewModel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class HomeScreenFragment : Fragment() {

    private val homeViewModel : HomeViewModel by viewModels()
    private lateinit var binding : FragmentHomeScreenBinding

    init {
        lifecycleScope.launchWhenCreated {
            homeViewModel.signUpFlow.collect {

               when (it.clickEvent) {
//                    ClickEvent.Nothing -> {
//                        if (it.error) {
//                            Toast.makeText(requireContext(),"Toast",Toast.LENGTH_SHORT).show()
//                        }
//                    }
                   ClickEvent.LoginTextClick -> {
                       Intent(requireActivity(), LoginOrSignUpActivity::class.java).also {
                           startActivity(it)
                           requireActivity().finish()
                       }
                   }
                   ClickEvent.UserListClick -> {
                       openUserListFragment()
                   }
               }
            }
        }
    }

    private fun openUserListFragment() {
        val userListFragment = UserListFragment()
        val userListFragmentObject = requireActivity().supportFragmentManager.beginTransaction()
        userListFragmentObject.replace(R.id.fragment_container_view,userListFragment)
       // userListFragmentObject.addToBackStack(LoginFragment::class.java.simpleName)
        userListFragmentObject.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_home_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = homeViewModel

    }
    val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}