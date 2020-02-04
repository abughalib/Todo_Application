package com.android.todo.viewdata

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
import com.android.todo.databinding.ViewDataFragmentBinding

class ViewData : Fragment() {

    private lateinit var viewModel: ViewDataViewModel
    private lateinit var binding: ViewDataFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.view_data_fragment, container, false)

        binding.addTaskFab.setOnClickListener {
            Toast.makeText(getActivity()?.getApplicationContext(), "Fill in the details", Toast.LENGTH_SHORT).show()
            onClickFab(it)
        }


        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun onClickFab(view: View){

        view.findNavController().navigate(R.id.action_viewData_to_addNewData)

    }

}
