package com.dewakoding.tutorialmvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Int?,
    @ColumnInfo("title")
    var title: String,
    @ColumnInfo("description")
    var description: String,
)
