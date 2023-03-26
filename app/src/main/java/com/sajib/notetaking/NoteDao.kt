package com.sajib.notetaking

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert
    fun noteInsert(note: Note)

    @Update
    fun noteUpdate(note: Note, NoteID: Int)

    @Delete
    fun noteDelete(note: Note)



}