package com.example.snehaAssignment1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentLoginBinding
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.viewModel.LoginViewModel
import com.example.snehaAssignment1.viewModel.SignUpViewModel

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    init {

        lifecycleScope.launchWhenCreated {
            loginViewModel.loginFlow.collect {

                when (it.clickEvent) {
                    ClickEvent.Nothing -> {
                        if (it.error) {
                            showToast(it.message ?: "")
                        }
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.btnLogin.setOnClickListener {
        }
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = loginViewModel
    }
}