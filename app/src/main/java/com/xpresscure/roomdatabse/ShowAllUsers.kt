package com.xpresscure.roomdatabse

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.xpresscure.roomdatabse.LocalStorage.Others.Adapter.UsersListAdapter
import com.xpresscure.roomdatabse.LocalStorage.Others.RoomResources.RoomViewModel
import com.xpresscure.roomdatabse.databinding.FragmentShowAllUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_show_all_users.*

@AndroidEntryPoint
class ShowAllUsers : Fragment() {

    lateinit var binding: FragmentShowAllUsersBinding
    private val mainViewModel: RoomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflate(inflater, R.layout.fragment_show_all_users, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.addUsers.setOnClickListener {
            findNavController().navigate(R.id.action_showAllUsers_to_consultDataLyt)
        }

        getAllUsers()

    }



    private fun getAllUsers() {

        mainViewModel.getUserData.observeForever {
            for(i in it){
                for (h in i.Hobbies){
                    Toast.makeText(context, "${h.item}", Toast.LENGTH_SHORT).show()
                }

            }

        }

//        mainViewModel.usersList.observeForever {
//            val adapter = UsersListAdapter(it)
//            binding.mainRCV.adapter = adapter
//            binding.mainRCV.layoutManager = LinearLayoutManager(context)
//            adapter.notifyDataSetChanged()
//        }



    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navDelete ->{
                val deleteDialog = MaterialAlertDialogBuilder(requireContext())
                deleteDialog.setMessage("Do You Want To Delete All User")
                deleteDialog.setPositiveButton("Yes"){_,_ ->
                    mainViewModel.deleteAllUsers()
                }
                deleteDialog.setNegativeButton("No"){_,_ ->
                }
                deleteDialog.show()
            }
        }
        return true
    }

}