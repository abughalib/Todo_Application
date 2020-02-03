package com.android.todo

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.todo.databinding.FragmentLoginPageBinding
import kotlinx.android.synthetic.main.fragment_login_page.*
import kotlin.system.exitProcess


class Login: Fragment(){

    lateinit var binding: FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_page, container, false)
        setHasOptionsMenu(true)

        //val myName = "Abughalib"

//      val password: String = binding.password.text.toString()

        val contextActivity = getActivity()?.getApplicationContext()

        binding.loginButton.setOnClickListener {view: View ->

            view.findNavController().navigate(R.id.action_loginFragment_to_viewData)
            Toast.makeText(contextActivity, "Login Success", Toast.LENGTH_SHORT).show()

        }

        binding.createNewuserButton.setOnClickListener {view: View ->

            view.findNavController().navigate(R.id.action_loginFragment_to_createUser)
            Toast.makeText(contextActivity, "Register Page", Toast.LENGTH_SHORT).show()

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
                Toast.makeText(getActivity()?.getApplicationContext(), "About", Toast.LENGTH_SHORT).show()
                return NavigationUI.onNavDestinationSelected(item, findNavController())
            }
            R.id.exit ->{
                Toast.makeText(context, "Exiting", Toast.LENGTH_SHORT).show()
                exitProcess(0)
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

}