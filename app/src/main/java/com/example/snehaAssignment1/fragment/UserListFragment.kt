package com.example.snehaAssignment1.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentUserListBinding
import com.example.snehaAssignment1.interfaces.ItemClickListener
import com.example.snehaAssignment1.model.UserDetailsList
import com.example.snehaAssignment1.viewModel.UserListViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserListFragment : Fragment(),ItemClickListener {

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
        userListViewModel.testFunction(this)

        GlobalScope.launch {
            userListViewModel.staticData()
            activity?.runOnUiThread(Runnable{
                Log.d("ANJALI","fragments")
                userListViewModel.adapter.notifyDataSetChanged()

            })
        }

    }

      override  fun onItemClickListener(position: Int,userDetails:UserDetailsList) {
            //openUserDetailsFragment
            val userDetailsFragment = UserDetailsFragment()
            val userDetailsFragmentObject = requireActivity().supportFragmentManager.beginTransaction()
            userDetailsFragmentObject.add(R.id.fragment_container_view_of_Home_activity, userDetailsFragment)
            userDetailsFragmentObject.addToBackStack(UserListFragment::class.java.simpleName)
            userDetailsFragmentObject.commit()
        }
}