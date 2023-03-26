package com.sajib.notetaking.roomimplementation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var NoteID: Int,
    @ColumnInfo(name = "note_title")
    var NoteTitle: String,
    @ColumnInfo(name = "note_description")
    var NoteDetails: String


)
