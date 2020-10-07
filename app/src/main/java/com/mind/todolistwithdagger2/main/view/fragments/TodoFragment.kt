package com.mind.todolistwithdagger2.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mind.todolistwithdagger2.R
import com.mind.todolistwithdagger2.main.view.adapters.SwipeToArchiveCallback
import com.mind.todolistwithdagger2.main.view.adapters.TaskAdapter
import com.mind.todolistwithdagger2.main.view.common.base.BaseViewModelFragment
import com.mind.todolistwithdagger2.main.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_todo.*


class TodoFragment : BaseViewModelFragment<TaskViewModel>(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //initViewModel()
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        initView()
        initRecyclerview()
        getTasks()
        enableSwipeToArchive()

    }

    private fun initRecyclerview() {
        taskAdapter = TaskAdapter()
        toDoRecyclerview.setHasFixedSize(true)
        toDoRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        toDoRecyclerview.adapter= taskAdapter
    }
    private fun getTasks() {
        viewModel.getTasks()
    }
    private fun initView() {
        btnAddToDo.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAddToDo -> navController.navigate(R.id.action_todoFragment_to_addTodoFragment)
        }
    }
    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.taskLiveEvent.observe(viewLifecycleOwner,{
            it?.let {
                taskAdapter.setList(it)
            }
        })

    }
    override fun buildViewModel(): TaskViewModel {
        return ViewModelProviders.of(this, viewModelFactory)[TaskViewModel::class.java]
    }
    override fun getContentResource(): Int = R.layout.fragment_todo
    override fun injectDagger() {
        initPresenterComponent()?.inject(this)
    }


    private fun enableSwipeToArchive() {
        //taskAdapter.getData()
        val swipeToArchiveCallback : SwipeToArchiveCallback = object : SwipeToArchiveCallback(requireContext(),8) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                super.onSwiped(viewHolder, direction)
                val position=viewHolder.adapterPosition
                val archivedTaskId = taskAdapter.getData()[position].id
                taskAdapter.removeItem(position)
                moveToArchive(archivedTaskId)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToArchiveCallback)
        itemTouchHelper.attachToRecyclerView(toDoRecyclerview)
    }

    private fun moveToArchive(archivedTaskId: Int) {
        viewModel.addToArchive(archivedTaskId)
    }


}