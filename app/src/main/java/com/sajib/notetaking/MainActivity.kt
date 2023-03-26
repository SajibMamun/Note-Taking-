package com.sajib.notetaking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sajib.notetaking.activities.CreateNoteActivity
import com.sajib.notetaking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.createnotebtn.setOnClickListener(View.OnClickListener {

            var intent= Intent(this,CreateNoteActivity::class.java)
            startActivity(intent)



        })
    }
}