package com.example.snehaAssignment1.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.model.UserListDetails

class UserListAdapter(val list: ArrayList<UserListDetails>) :
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTextView = itemView.findViewById<TextView>(R.id.name)
        val emailTextView = itemView.findViewById<TextView>(R.id.email)
        val phoneNumberTextView = itemView.findViewById<TextView>(R.id.phoneNumber)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : UserListAdapter.UserListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val todoView = inflater.inflate(R.layout.fragment_user_list, parent, false)
        return UserListViewHolder(todoView)
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserListViewHolder, position: Int) {
        holder.taskTextView.text = list[position].name
        holder.emailTextView.text = list[position].email
        holder.phoneNumberTextView.text = list[position].phoneNumber
    }

    override fun getItemCount(): Int {
        return list.size
    }
}