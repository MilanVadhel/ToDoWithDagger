package com.mind.todolistwithdagger2.main.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mind.todolistwithdagger2.main.viewmodel.TaskViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {


    @Singleton
    @Binds
    abstract fun bindViewModel(viewModelProvider: ViewModelProvider) : ViewModelProvider


    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    abstract fun bindTaskViewMode(viewModel: TaskViewModel): ViewModel

}