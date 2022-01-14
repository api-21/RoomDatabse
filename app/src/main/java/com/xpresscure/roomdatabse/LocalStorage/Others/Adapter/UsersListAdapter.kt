package com.xpresscure.roomdatabse.LocalStorage.Others.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import com.xpresscure.roomdatabse.R
import com.xpresscure.roomdatabse.ShowAllUsersDirections
import kotlinx.android.synthetic.main.userslist_lyt.view.*

class UsersListAdapter(val userList: List<Users>) :
    RecyclerView.Adapter<UsersListAdapter.UsersViewHolder>() {

    inner class UsersViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.userslist_lyt, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.itemView.apply {
            val userItem = userList[position]
            userName.text = userItem.name
            userAddress.text = userItem.village
            userCount.text = userItem.id.toString()
         setOnClickListener {
                val action = ShowAllUsersDirections.actionShowAllUsersToDeleteUsers(userItem)
                findNavController().navigate(action)
            }

        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}