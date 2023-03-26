package com.sajib.notetaking.roomimplementation

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.sajib.notetaking.roomimplementation.Note

@Dao
interface NoteDao {
    @Insert
    fun noteInsert(note: Note)

    @Update
    fun noteUpdate(note: Note)

    @Delete
    fun noteDelete(note: Note)



}