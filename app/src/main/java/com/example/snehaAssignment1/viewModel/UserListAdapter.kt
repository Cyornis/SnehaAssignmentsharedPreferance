package com.example.snehaAssignment1.viewModel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.UserListItemBinding
import com.example.snehaAssignment1.fragment.UserDetailsFragment
import com.example.snehaAssignment1.interfaces.ItemClickListener
import com.example.snehaAssignment1.model.UserDetails
import com.example.snehaAssignment1.model.UserDetailsList

class UserListAdapter(private val list: ArrayList<UserDetailsList>) : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private lateinit var itemClickListener: ItemClickListener
    inner class UserListViewHolder(val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : UserListAdapter.UserListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = UserListItemBinding.inflate(inflater,parent,false)

        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserListViewHolder, position: Int) {
        holder.binding.name.text=list[position].name
        holder.binding.email.text=list[position].email
        holder.binding.phoneNumber.text=list[position].id.toString()

        holder.itemView.setOnClickListener {
            Log.d("ANJALI","itemViewClicked")
            itemClickListener.onItemClickListener(position,list[position])

        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    fun testFunct(itemClickListener: ItemClickListener){
        this.itemClickListener=itemClickListener
    }
}