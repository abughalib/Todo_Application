package com.android.todo.addNewData

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

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

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddNewDataViewModel::class.java)

    }

}
