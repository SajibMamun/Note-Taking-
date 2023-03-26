package com.sajib.notetaking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sajib.notetaking.databinding.ActivityCreateNoteBinding

class CreateNoteActivity : AppCompatActivity() {

    lateinit var title:String
    lateinit var notedescrip:String
    var noteid:Int=0
    lateinit var binding: ActivityCreateNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.savebtnid.setOnClickListener {
            title=binding.notetitleEtid.text.toString()
            notedescrip=binding.notedescripEtid.text.toString()





            var noteobj= Note(noteid, title, notedescrip)
            var noteDao=UserDatabase.getInstance(this).getNoteDao()
            noteDao.noteInsert(noteobj)




            var intent= Intent(this, MainActivity::class.java)
            startActivity(intent)









        }





    }
}