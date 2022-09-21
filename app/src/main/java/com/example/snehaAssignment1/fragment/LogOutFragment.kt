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
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentLogOutBinding
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.view.LoginOrSignUpActivity
import com.example.snehaAssignment1.viewModel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class LogOutFragment : Fragment() {

    private val homeViewModel : HomeViewModel by viewModels()
    private lateinit var binding : FragmentLogOutBinding

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
               }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_log_out, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = homeViewModel

    }
    val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}