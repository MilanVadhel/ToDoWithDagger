package com.mind.todolistwithdagger2.main.di.presenter

import androidx.lifecycle.ViewModel
import javax.inject.Qualifier
import kotlin.reflect.KClass

@MustBeDocumented
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>) {
}