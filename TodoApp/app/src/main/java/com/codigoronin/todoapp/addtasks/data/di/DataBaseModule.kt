package com.codigoronin.todoapp.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.codigoronin.todoapp.addtasks.data.TaskDao
import com.codigoronin.todoapp.addtasks.data.TodoDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideTodoDataBase(@ApplicationContext appContext: Context): TodoDataBase {
        return Room.databaseBuilder(appContext, TodoDataBase::class.java, "TaskDataBase").build()
    }

    @Provides
    fun provideTaskDao(todoDataBase: TodoDataBase): TaskDao {
        return todoDataBase.taskDao()
    }
}