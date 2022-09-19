package com.example.snehaAssignment1.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
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
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences

    init {

        lifecycleScope.launchWhenCreated {
            loginViewModel.loginFlow.collect {

                when (it.clickEvent) {
                    ClickEvent.Nothing -> {
                        if (it.error) {
                            showToast(it.message ?: "")
                        }
                    }
                    ClickEvent.SignUpTextClick -> {
                        openSignUpFragment()
                    }
                }
            }
        }
    }

    private fun openSignUpFragment() {
        val signUpFragment = SignUpFragment()
        val signUpFragmentObject = requireActivity().supportFragmentManager.beginTransaction()
        signUpFragmentObject.add(R.id.fragment_container_view,signUpFragment)
        signUpFragmentObject.addToBackStack(LoginFragment::class.java.simpleName)
        signUpFragmentObject.commit()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = loginViewModel

        binding.btnLogin.setOnClickListener {

            loginViewModel.onLoginBtnClick()
            sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(requireContext())

        }
    }
    val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}