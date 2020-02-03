package com.android.todo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_todo_list_table")

data class TodoList(
    @PrimaryKey(autoGenerate = true)
    var TodoId: Long = 0L,

    @ColumnInfo(name = "user_name")
    var userName: String = "Abughalib",

    @ColumnInfo(name = "password")
    var password: String = "Abu@1234",

    @ColumnInfo(name ="start_time")
    var startTime: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "end_time")
    var endTime: Long = startTime,

    @ColumnInfo(name= "priority")
    var priority: Int = 0,

    @ColumnInfo(name = "Things")
    var thingToDo: String = "Nothing"

)