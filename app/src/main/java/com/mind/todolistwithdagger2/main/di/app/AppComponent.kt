package com.mind.todolistwithdagger2.main.di.app

import dagger.Component

@Component(modules = [AppModule::class,DatabaseModule::class])
interface AppComponent {

}