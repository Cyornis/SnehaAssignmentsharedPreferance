package com.example.snehaAssignment1.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.model.UserDetails

class UserListAdapter(private val list: ArrayList<UserDetails>) :
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val taskTextView = itemView.findViewById<TextView>(R.id.name)
        val emailTextView = itemView.findViewById<TextView>(R.id.email)
        val phoneNumberTextView = itemView.findViewById<TextView>(R.id.phone_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : UserListAdapter.UserListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val todoView = inflater.inflate(R.layout.user_list_item, parent, false)

        return UserListViewHolder(todoView)
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserListViewHolder, position: Int) {
        holder.taskTextView.text = list[position].name
        holder.emailTextView.text = list[position].email
        holder.phoneNumberTextView.text = list[position].phone_number
    }

    override fun getItemCount(): Int {
        return list.size
    }
}