package com.example.snehaAssignment1.viewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.snehaAssignment1.databinding.UserPostItemBinding
import com.example.snehaAssignment1.databinding.UserToDoListBinding
import com.example.snehaAssignment1.model.UserPost

class UserPostAdapter(val userPost : ArrayList<UserPost>):RecyclerView.Adapter<UserPostAdapter.UserPostViewHolder>(){

    inner class UserPostViewHolder(val binding: UserPostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserPostAdapter.UserPostViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = UserPostItemBinding.inflate(inflater,parent,false)

        return UserPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserPostAdapter.UserPostViewHolder, position: Int) {
       //ToDO
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}