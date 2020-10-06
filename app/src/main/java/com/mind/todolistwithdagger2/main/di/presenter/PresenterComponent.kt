package com.mind.todolistwithdagger2.main.di.presenter

import com.mind.todolistwithdagger2.main.di.app.AppComponent
import com.mind.todolistwithdagger2.main.di.viewmodel.ViewModelModule
import com.mind.todolistwithdagger2.main.view.activities.MainActivity
import com.mind.todolistwithdagger2.main.view.fragments.AddTodoFragment
import com.mind.todolistwithdagger2.main.view.fragments.ArchiveFragment
import com.mind.todolistwithdagger2.main.view.fragments.TodoFragment
import com.unittestsample.app.di.viewmodel.ViewModelFactoryModule
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [ViewModelModule::class, ViewModelFactoryModule::class])

@PerPresenter
interface PresenterComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(todoFragment: TodoFragment)
    fun inject(archiveFragment: ArchiveFragment)
    fun inject(addTodoFragment: AddTodoFragment)

}