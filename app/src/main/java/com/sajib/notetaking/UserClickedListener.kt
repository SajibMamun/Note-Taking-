package com.sajib.notetaking

import android.content.Context
import com.sajib.notetaking.roomdb.Note

interface UserClickedListener {
    fun NoteDelete(note: Note, context: Context)
    fun NoteUpdate(note: Note)


}