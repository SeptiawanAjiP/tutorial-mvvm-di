package com.dewakoding.tutorialmvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dewakoding.tutorialmvvm.data.model.Note


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
@Dao
interface NoteDao {
    // CREATE
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    // READ
    @Query("SELECT * FROM notes")
    fun getAll(): LiveData<List<Note>>

    // UPDATE
    @Update
    suspend fun update(note: Note)

    // DELETE
    @Delete
    suspend fun delete(note: Note)
}