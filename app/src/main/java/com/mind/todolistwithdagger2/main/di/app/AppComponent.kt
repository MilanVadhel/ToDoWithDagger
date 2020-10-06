package com.mind.todolistwithdagger2.main.di.app

import com.mind.todolistwithdagger2.main.AppController
import com.mind.todolistwithdagger2.main.repositories.TaskRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, DatabaseModule::class])

@Singleton
interface AppComponent {
    fun inject(appController: AppController)
    fun taskRepository(): TaskRepository
}