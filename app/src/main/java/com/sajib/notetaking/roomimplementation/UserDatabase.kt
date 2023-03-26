package com.sajib.notetaking.roomimplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract  class UserDatabase:RoomDatabase() {
    abstract fun getNoteDao(): NoteDao


    companion object

    var db: UserDatabase? = null


     fun getInstance(context: Context): UserDatabase {

        if (db == null) {

            db = Room.databaseBuilder(
                context,
                UserDatabase::class.java, "user_db"
            )
                .allowMainThreadQueries().build()
        }
            return db as UserDatabase

    }


}