package com.dewakoding.tutorialmvvm.repository

import com.dewakoding.tutorialmvvm.data.AppDatabase
import com.dewakoding.tutorialmvvm.data.dao.NoteDao
import com.dewakoding.tutorialmvvm.data.model.Note
import javax.inject.Inject


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
class NoteRepository @Inject constructor(
    val noteDao: NoteDao
) {
    fun getAll() = noteDao.getAll()

    suspend fun insert(note: Note) = noteDao.insert(note)

    suspend fun delete(note: Note) = noteDao.delete(note)
}