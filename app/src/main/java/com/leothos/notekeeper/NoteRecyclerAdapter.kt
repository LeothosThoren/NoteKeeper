package com.leothos.notekeeper

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.leothos.notekeeper.activities.AddNotesActivity

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = DataManager.notes[position]
        holder.txtCourse.text = note.course?.title
        holder.txtDescription.text = note.title
        holder.notePosition = position
    }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCourse = itemView.findViewById(R.id.textViewCourse) as TextView
        val txtDescription = itemView.findViewById(R.id.textViewDescription) as TextView
        var notePosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, AddNotesActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }

    }
}