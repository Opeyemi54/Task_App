package com.hfad.taskapp.dataBase

import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import android.content.Context
import com.hfad.taskapp.model.Task
import com.hfad.taskapp.model.TaskDao


@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract val taskDao : TaskDao

}