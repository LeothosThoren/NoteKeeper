package com.leothos.notekeeper.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.leothos.notekeeper.DataManager
import com.leothos.notekeeper.NOTE_POSITION
import com.leothos.notekeeper.NoteInfo
import com.leothos.notekeeper.R
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.content_note.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        setSupportActionBar(toolbar)

        fabNote.setOnClickListener {
            val intentActivity = Intent(this@NoteListActivity, AddNotesActivity::class.java)
            startActivity(intentActivity)
        }

        this.configureList()
    }

    //****************
    // Configurations
    //****************

    private fun configureList() {
        listNote.adapter = ArrayAdapter<NoteInfo>(
            this, android.R.layout.simple_list_item_1, DataManager.notes
        )

        listNote.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@NoteListActivity, AddNotesActivity::class.java)
            intent.putExtra(NOTE_POSITION, position)
            startActivity(intent)
        }

    }

    override fun onResume() {
        (listNote.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
        super.onResume()

    }
}
