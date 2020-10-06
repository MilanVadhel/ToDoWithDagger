package com.mind.todolistwithdagger2.main

import android.app.Application
import com.mind.todolistwithdagger2.main.di.app.AppComponent
import com.mind.todolistwithdagger2.main.di.app.AppModule
import com.mind.todolistwithdagger2.main.di.app.DaggerAppComponent
import com.mind.todolistwithdagger2.main.di.app.DatabaseModule

class AppController : Application() {

    companion object {
        lateinit var appController: AppController
            private set

    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appController = this
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this))
            .databaseModule(DatabaseModule(this)).build()
        appComponent.inject(appController)
    }


}