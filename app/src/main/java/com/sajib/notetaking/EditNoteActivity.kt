package com.sajib.notetaking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sajib.notetaking.databinding.ActivityEditNoteBinding
import com.sajib.notetaking.roomdb.Note
import com.sajib.notetaking.roomdb.UserDatabase

class EditNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var getintent = intent
        var id: Int = getintent.getIntExtra("id", 0)
        var ptitle: String = getintent.getStringExtra("title").toString()
        var pdescription: String = getintent.getStringExtra("description").toString()

        binding.updatenotebtnid.setOnClickListener {
           var ettitle:String = binding.notetitleEtid.text.toString()
            var etdescrip:String = binding.notedescripEtid.text.toString()


            var noteobj = Note(id, ettitle, etdescrip)
            var noteDao = UserDatabase.getInstance(this).getNoteDao()
            noteDao.noteUpdate(noteobj)

            var intent1=Intent(this,MainActivity::class.java)
            startActivity(intent1)


        }
    }
}