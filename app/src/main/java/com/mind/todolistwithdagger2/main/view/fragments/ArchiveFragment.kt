package com.mind.todolistwithdagger2.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mind.todolistwithdagger2.R
import com.mind.todolistwithdagger2.main.view.adapters.TaskAdapter
import com.mind.todolistwithdagger2.main.view.common.base.BaseViewModelFragment
import com.mind.todolistwithdagger2.main.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_archive.*


class ArchiveFragment : BaseViewModelFragment<TaskViewModel>() {

    private lateinit var taskAdapter: TaskAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_archive, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        getArchivedTasks()
    }

    private fun initRecyclerview() {
        taskAdapter = TaskAdapter()
        archivedRecyclerview.setHasFixedSize(true)
        archivedRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        archivedRecyclerview.adapter= taskAdapter
    }
    private fun getArchivedTasks() {
        viewModel.getArchivedTask()
    }
    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.archivedTaskLiveEvent.observe(viewLifecycleOwner,{
            it?.let {
                taskAdapter.setList(it)
            }
        })

    }
    override fun buildViewModel(): TaskViewModel {
        return ViewModelProviders.of(this, viewModelFactory)[TaskViewModel::class.java]
    }
    override fun getContentResource() = R.layout.fragment_archive
    override fun injectDagger() {
        initPresenterComponent()?.inject(this)
    }

}