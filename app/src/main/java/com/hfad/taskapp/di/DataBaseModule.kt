package com.hfad.taskapp.di

import android.content.Context
import androidx.room.Room
import com.hfad.taskapp.dataBase.TaskDatabase
import com.hfad.taskapp.model.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBaseBuilder(@ApplicationContext context: Context): TaskDatabase{
       return Room.databaseBuilder(context, TaskDatabase::class.java, "name").build()
    }

    @Provides
    @Singleton
    fun provideDaoClassToDataBase(taskDatabase: TaskDatabase): TaskDao{
        return taskDatabase.taskDao
    }
}