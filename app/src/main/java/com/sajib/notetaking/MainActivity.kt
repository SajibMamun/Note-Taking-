package com.sajib.notetaking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sajib.notetaking.RecyclerView.NoteAdapter
import com.sajib.notetaking.databinding.ActivityMainBinding
import com.sajib.notetaking.roomdb.Note
import com.sajib.notetaking.roomdb.UserDatabase

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//create note activity
        binding.createnotebtn.setOnClickListener(View.OnClickListener {

            var intent= Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
         })
    }


    override fun onResume() {
        super.onResume()

//recyclerview
        var noteadapter=NoteAdapter(this)
        binding.recyclerviewid.adapter=noteadapter



        //Read data from db
        var noteDao= UserDatabase.getInstance(this).getNoteDao()
        var NoteList: List<Note> = noteDao.getAllNotes()

        NoteList.forEach {
            noteadapter.submitList(NoteList)
        }

    }






}