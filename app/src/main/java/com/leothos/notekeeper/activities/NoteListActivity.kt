package com.leothos.notekeeper.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.leothos.notekeeper.DataManager
import com.leothos.notekeeper.NoteRecyclerAdapter
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

        this.configureRecyclerView()
    }

    //****************
    // Configurations
    //****************

    private fun configureRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NoteRecyclerAdapter(this, DataManager.notes)
    }

    override fun onResume() {
        super.onResume()
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
