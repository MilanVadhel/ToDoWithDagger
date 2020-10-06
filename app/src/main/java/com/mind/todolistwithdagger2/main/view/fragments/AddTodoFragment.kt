package com.mind.todolistwithdagger2.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.mind.todolistwithdagger2.R
import com.mind.todolistwithdagger2.main.database.entity.Task
import com.mind.todolistwithdagger2.main.di.presenter.PresenterComponent
import com.mind.todolistwithdagger2.main.view.common.base.BaseViewModelFragment
import com.mind.todolistwithdagger2.main.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_addtodo.*


class AddTodoFragment : BaseViewModelFragment<TaskViewModel>(), View.OnClickListener{

    private lateinit var taskViewModel: TaskViewModel
    private var categoryArray = arrayOf("Development","Design","Testing")
    private lateinit var category : String
    private lateinit var presenterComponent: PresenterComponent
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_addtodo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= view.findNavController()
        initView()
        setCategory()
        initPresenterComponent()
    }


    private fun setCategory() {
        spinnerCategory.adapter = ArrayAdapter(activity?.applicationContext!!,android.R.layout.simple_spinner_dropdown_item,categoryArray
            )
        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                category = categoryArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                category = null.toString()

            }
        }
    }



    private fun initView() {
        btnSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSave -> saveTask()
        }
    }

    private fun saveTask() {
        viewModel.addTask(Task(edtTitle.text.toString(),edtDescription.text.toString(),System.currentTimeMillis().toString(),category))
        clearFields()
    }

    private fun clearFields() {
        edtTitle.setText("")
        edtDescription.setText("")
        navController.navigate(R.id.action_addTodoFragment_to_todoFragment)
    }

    override fun buildViewModel(): TaskViewModel {
       return ViewModelProviders.of(this,viewModelFactory)[TaskViewModel::class.java]
    }

    override fun getContentResource(): Int = R.layout.fragment_addtodo

    override fun injectDagger() {
        initPresenterComponent()?.inject(this)
    }


}