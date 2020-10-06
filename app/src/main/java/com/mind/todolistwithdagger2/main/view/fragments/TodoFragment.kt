package com.mind.todolistwithdagger2.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.mind.todolistwithdagger2.R
import com.mind.todolistwithdagger2.main.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_todo.*


class TodoFragment : Fragment(), View.OnClickListener{

private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        initView()
        ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    private fun initView() {
        btnAddToDo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnAddToDo -> navController.navigate(R.id.action_todoFragment_to_addTodoFragment)
        }
    }


}