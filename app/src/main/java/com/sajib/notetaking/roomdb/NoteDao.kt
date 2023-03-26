package com.sajib.notetaking.roomdb

import androidx.room.*
import com.sajib.notetaking.roomdb.Note


@Dao
interface NoteDao {
    @Insert
    fun noteInsert(note: Note)

    @Update
    fun noteUpdate(note: Note)

    @Delete
    fun noteDelete(note: Note)


    // getting all notes
    //tablename
    @Query("SELECT * FROM Note")
    fun getAllNotes():List<Note>



}