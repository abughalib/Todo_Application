package com.android.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoList::class], version = 1, exportSchema = false)
abstract class TodoListDatabase: RoomDatabase(){

    abstract val todoListDatabaseDao: TodoDatabaseDao

    companion object{

        @Volatile
        private var INSTANCE: TodoListDatabase? = null

        fun getInstance(context: Context): TodoListDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, TodoListDatabase::class.java,
                        "Todo_List_History"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}