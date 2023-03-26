package com.sajib.notetaking.roomdb

interface UserClickedListener {
    fun NoteDelete(note:Note)
    fun NoteUpdate(note:Note)


}