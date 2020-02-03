package com.android.todo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDatabaseDao {

    @Insert
    fun insert(todo: TodoList)

    @Update
    fun update(todo: TodoList)

    @Query("SELECT * FROM daily_todo_list_table WHERE todoId = :key")
    fun get(key: Long): TodoList?

    @Query("DELETE FROM daily_todo_list_table")
    fun clear()

    @Query("SELECT * FROM daily_todo_list_table ORDER BY todoId DESC")
    fun getAllTodos(): LiveData<List<TodoList>>

    @Query("SELECT * FROM daily_todo_list_table ORDER BY todoId DESC LIMIT 1")
    fun getToday(): TodoList?

}