package com.mind.todolistwithdagger2.main.di.presenter

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

//@MustBeDocumented
//@Qualifier
//@Retention(AnnotationRetention.RUNTIME)

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>) {
}