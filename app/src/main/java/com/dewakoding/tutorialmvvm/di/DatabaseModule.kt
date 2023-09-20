package com.dewakoding.tutorialmvvm.di

import android.content.Context
import androidx.room.Room
import com.dewakoding.tutorialmvvm.App
import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =  Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "note_database")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase) = db.noteDao()

}