package com.android.todo.addNewData

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.android.todo.R
import com.android.todo.databinding.AddNewDataFragmentBinding

class AddNewData : Fragment() {

    private lateinit var viewModel: AddNewDataViewModel
    private lateinit var binding: AddNewDataFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  DataBindingUtil.inflate(inflater, R.layout.add_new_data_fragment, container, false)

        binding.addTaskButton.setOnClickListener {

            Toast.makeText(getActivity()?.getApplicationContext(), "New Task Added", Toast.LENGTH_SHORT).show()
            addData(it)

        }

        binding.cancelTaskAddition.setOnClickListener { view: View ->

            Toast.makeText(getActivity()?.getApplicationContext(), "Cancelled adding task", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_addNewData_to_viewData)
        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddNewDataViewModel::class.java)

    }

    private fun addData(view: View){

        view.findNavController().navigate(R.id.action_addNewData_to_viewData)

    }

}
