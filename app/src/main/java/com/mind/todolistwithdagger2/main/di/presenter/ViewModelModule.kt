package com.mind.todolistwithdagger2.main.di.presenter

import androidx.lifecycle.ViewModel
import com.mind.todolistwithdagger2.main.viewmodel.TaskViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    abstract fun bindTaskViewMode(viewModel: TaskViewModel): ViewModel

}