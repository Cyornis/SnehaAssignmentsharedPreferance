package com.example.snehaAssignment1.fragment

import android.app.DatePickerDialog
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
import com.example.snehaAssignment1.databinding.FragmentSignUpBinding
import com.example.snehaAssignment1.model.ClickEvent
import com.example.snehaAssignment1.viewModel.SignUpViewModel
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val signUpViewModel: SignUpViewModel by viewModels()

    init {

        lifecycleScope.launchWhenCreated {
            signUpViewModel.signUpFlow.collect {

                when (it.clickEvent) {
                    ClickEvent.Nothing -> {
                        if (it.error) {
                            showToast(it.message ?: "")
                        }
                    }
                    ClickEvent.LoginTextClick -> {
                       openLoginFragment()
                    }
                }
            }
        }
    }

    private fun openLoginFragment() {
        //creating Login Fragment
        val loginFragment = LoginFragment()
        val loginFragmentObject = activity?.supportFragmentManager?.beginTransaction()
        loginFragmentObject?.replace(R.id.fragment_container_view,loginFragment)
        loginFragmentObject?.commit()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = Calendar.getInstance().time

        binding.tvDob.text = formatter.format(date)
        binding.vm = signUpViewModel
        binding.tvDob.setOnClickListener {

            fun clickDataPicker(view: View) {

                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val date = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    requireActivity(),
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                        binding.tvDob.text = "$year - ${monthOfYear + 1} - $dayOfMonth"

                    }, year, month, date
                )
                dpd.show()
            }
        }

    }

    val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}
