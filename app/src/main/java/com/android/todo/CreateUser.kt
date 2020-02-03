package com.android.todo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.todo.databinding.FragmentCreateUserBinding
import kotlinx.android.synthetic.main.fragment_create_user.*
import kotlinx.android.synthetic.main.fragment_login_page.*
import kotlin.system.exitProcess


class CreateUser : Fragment() {

    private lateinit var binding: FragmentCreateUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_user, container, false)

        //To be implemented to sqlite data base on button click
        val newUserName: String = binding.inputName.text.toString()
        val newPassword: String = binding.inputPassword.text.toString()

        binding.registerButton.setOnClickListener {

            if(newUserName.isNotEmpty() and newPassword.isNotEmpty())

            Toast.makeText(getActivity()?.getApplicationContext(), "Register successful", Toast.LENGTH_SHORT).show()

        }

        binding.cancelButton.setOnClickListener {
            Toast.makeText(getActivity()?.getApplicationContext(), "Cancelled Registration", Toast.LENGTH_SHORT).show()
        }



        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){

            R.id.aboutFragment ->{

                Toast.makeText(getActivity()?.getApplicationContext(), "AboutFragment", Toast.LENGTH_SHORT).show()
                return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
            }

            R.id.exit ->{
                exitProcess(0)
            }

            else -> super.onOptionsItemSelected(item)

        }

    }


}
