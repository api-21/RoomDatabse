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
import com.xpresscure.roomdatabse.databinding.FragmentCreateUsersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateUsers : Fragment() {

    lateinit var binding: FragmentCreateUsersBinding
    private val mainViewModel: RoomViewModel by viewModels()

    private lateinit var userName : EdtLytBinding
    private lateinit var userAddress : EdtLytBinding
    private lateinit var btnAddUser : ButtonLytBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflate(inflater, R.layout.fragment_create_users, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        userName = EdtLytBinding.inflate(layoutInflater)
        userAddress = EdtLytBinding.inflate(layoutInflater)
        btnAddUser = ButtonLytBinding.inflate(layoutInflater)

//        binding.createUserLyt.addView(userName.edtLyt)
//        binding.createUserLyt.addView(userAddress.edtLyt)
//        binding.createUserLyt.addView(btnAddUser.btnLyt)

        binding.createUserLyt.addView(userName.edtLyt)
        userName.edtLytEdt.hint ="Enter Your Name Here"

        binding.createUserLyt.addView(userAddress.edtLyt)
        userAddress.edtLytEdt.hint ="Enter Your Address"

        binding.createUserLyt.addView(btnAddUser.btnLyt)
        btnAddUser.btnLyt.text ="Add New User"

        btnAddUser.btnLyt.setOnClickListener {
            val name = userName.edtLytEdt.text.toString()
            val village = userAddress.edtLytEdt.text.toString()
            if (validatee(name, village)) addUsersToRoom(name, village)
        }

    }
    private fun addUsersToRoom(name: String, village: String) {
        val users = Users(0, name, village)
        mainViewModel.createUser(users)
        findNavController().navigate(R.id.action_createUsers_to_showAllUsers)
    }
    private fun validatee(name: String, village: String): Boolean {
        if (name.isNullOrEmpty() && village.isNullOrEmpty()) {
            return false
        }
        return true
    }

}