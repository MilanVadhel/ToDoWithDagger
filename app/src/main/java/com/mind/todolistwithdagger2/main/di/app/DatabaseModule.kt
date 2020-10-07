package com.mind.todolistwithdagger2.main.di.app

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mind.todolistwithdagger2.main.database.ToDoRoom
import com.mind.todolistwithdagger2.main.database.dao.TaskDao
import com.mind.todolistwithdagger2.main.repositories.TaskRepository
import com.mind.todolistwithdagger2.main.repositories.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideRoom(): ToDoRoom {
        return Room.databaseBuilder(application, ToDoRoom::class.java, "todo")
            .allowMainThreadQueries().setJournalMode(
                RoomDatabase.JournalMode.TRUNCATE
            ).fallbackToDestructiveMigration().build()
    }


    @Provides
    fun provideTaskDao(toDoRoom: ToDoRoom): TaskDao {
        return toDoRoom.getTaskDao()
    }


    @Provides
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepositoryImpl(taskDao)
    }
}