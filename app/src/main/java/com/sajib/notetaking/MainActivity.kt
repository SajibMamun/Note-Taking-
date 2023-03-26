package com.sajib.notetaking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.sajib.notetaking.databinding.ActivityMainBinding
import com.sajib.notetaking.roomdb.Note
import com.sajib.notetaking.roomdb.NoteDao
import com.sajib.notetaking.roomdb.UserDatabase



class MainActivity : AppCompatActivity(), UserClickedListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var noteDao: NoteDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//create note activity
        binding.createnotebtn.setOnClickListener(View.OnClickListener {

            var intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        })







    }


    override fun onResume() {
        super.onResume()
        //create an object of main activity to get access update and delete
        var mainActivity: UserClickedListener = MainActivity()

//recyclerview
        var noteadapter = NoteAdapter(this, mainActivity)
        binding.recyclerviewid.adapter = noteadapter


        //Read data from db
        noteDao = UserDatabase.getInstance(this).getNoteDao()

        var NoteList: List<Note> = noteDao.getAllNotes()
        NoteList.forEach {
            noteadapter.submitList(NoteList)
        }



    }


    //Implements Interface for update delete to access from Adapter
    override fun NoteDelete(note: Note,context: Context) {
        noteDao = UserDatabase.getInstance(context).getNoteDao()

        val builder = AlertDialog.Builder(context)
        //builder.setTitle("Androidly Alert")
        builder.setMessage("Want to Delete this")

        builder.setPositiveButton("Yes") { dialog, which ->
         noteDao.noteDelete(note)

        }

        builder.setNegativeButton("no") { dialog, which ->

        }
        builder.show()

    }

    override fun NoteUpdate(note: Note) {

    }


}