package com.dewakoding.tutorialmvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dewakoding.tutorialmvvm.data.dao.NoteDao
import com.dewakoding.tutorialmvvm.data.model.Note


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
@Database(entities = arrayOf(Note::class), version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}