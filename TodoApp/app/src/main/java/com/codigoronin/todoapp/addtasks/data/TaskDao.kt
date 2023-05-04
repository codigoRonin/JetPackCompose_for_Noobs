package com.codigoronin.todoapp.addtasks.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM TaskEntity")
    fun getTask(): Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(item:TaskEntity)
    @Update
    suspend fun updateTask(taskEntity: TaskEntity)
    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)
}