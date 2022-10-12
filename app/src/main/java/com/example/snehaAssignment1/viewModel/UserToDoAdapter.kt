package com.example.snehaAssignment1.viewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.snehaAssignment1.databinding.UserListItemBinding
import com.example.snehaAssignment1.databinding.UserToDoListBinding
import com.example.snehaAssignment1.model.UserToDo

class UserToDoAdapter(val userToDo : ArrayList<UserToDo>) : RecyclerView.Adapter<UserToDoAdapter.UserToDoViewHolder>(){

    inner class UserToDoViewHolder(val binding: UserToDoListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserToDoViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = UserToDoListBinding.inflate(inflater,parent,false)

        return UserToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserToDoAdapter.UserToDoViewHolder, position: Int) {
      holder.binding.UserID.text = userToDo[position].userId.toString()
        holder.binding.ID.text = userToDo[position].id.toString()
        holder.binding.title.text = userToDo[position].title
        holder.binding.completed.text = userToDo[position].completed

    }

    override fun getItemCount(): Int {
       return  userToDo.size
    }


}