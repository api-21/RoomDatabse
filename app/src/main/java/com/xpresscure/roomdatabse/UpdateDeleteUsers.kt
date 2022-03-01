package com.xpresscure.roomdatabse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.xpresscure.roomdatabse.LocalStorage.Others.Models.Users
import com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources.RoomViewModel
import com.xpresscure.roomdatabse.databinding.ButtonLytBinding
import com.xpresscure.roomdatabse.databinding.EdtLytBinding
import com.xpresscure.roomdatabse.databinding.FragmentDeleteUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_delete_users.*

@AndroidEntryPoint
class UpdateDeleteUsers : Fragment() {
    lateinit var binding: FragmentDeleteUsersBinding
    private val mainViewModel: RoomViewModel by viewModels()

    private lateinit var userName : EdtLytBinding
    private lateinit var userAddress : EdtLytBinding
    private lateinit var btnUpdateUser : ButtonLytBinding
    private lateinit var btnDeleteUser : ButtonLytBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflate(inflater, R.layout.fragment_delete_users, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName = EdtLytBinding.inflate(layoutInflater)
        userName.edtLytEdt.hint ="Username"
        userAddress = EdtLytBinding.inflate(layoutInflater)
        userAddress.edtLytEdt.hint ="User Address"
        btnDeleteUser = ButtonLytBinding.inflate(layoutInflater)
        btnDeleteUser.btnLyt.text ="Delete User"
        btnUpdateUser = ButtonLytBinding.inflate(layoutInflater)
        btnUpdateUser.btnLyt.text ="Update User"

        binding.updateLyt.addView(userName.edtLyt)
        binding.updateLyt.addView(userAddress.edtLyt)
        binding.updateLyt.addView(btnUpdateUser.btnLyt)
        binding.updateLyt.addView(btnDeleteUser.btnLyt)

        val name = userName.edtLytEdt.text.toString()
        val village = userAddress.edtLytEdt.text.toString()
        val users = Users(0, name, village)

        btnUpdateUser.btnLyt.setOnClickListener {
            if (validatee(name, village)) updateUser(users)
            findNavController().navigate(R.id.action_deleteUsers_to_showAllUsers)
        }

       btnDeleteUser.btnLyt.setOnClickListener {
            if (validatee(name, village)) deleteUsers(users)
            findNavController().navigate(R.id.action_deleteUsers_to_showAllUsers)
        }


    }

    private fun validatee(name: String, village: String): Boolean {
        if (!name.isNullOrEmpty() && village.isNullOrEmpty())
            return true
        return false
    }

    private fun deleteUsers(users: Users) {
        mainViewModel.deleteCurrentUsers(users)
    }

    private fun updateUser(users: Users) {
        mainViewModel.updateCurrentUsers(users)
    }

}