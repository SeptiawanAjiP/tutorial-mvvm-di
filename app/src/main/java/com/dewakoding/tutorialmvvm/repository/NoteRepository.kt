package com.dewakoding.tutorialmvvm.repository

import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.model.Note


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
class NoteRepository(
    private val db: AppDatabase
) {
    fun getAll() = db.noteDao().getAll()

    suspend fun insert(note: Note) = db.noteDao().insert(note)

    suspend fun delete(note: Note) = db.noteDao().delete(note)
}