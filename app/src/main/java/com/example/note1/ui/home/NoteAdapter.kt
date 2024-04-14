package com.example.note1.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.note1.R
import com.example.note1.databinding.ActivityCreateNoteBinding
import com.example.note1.databinding.NoteItemBinding
import com.example.note1.entities.Note
import java.text.SimpleDateFormat

class NoteAdapter (private val mNotes: List<Note>,private val listener: OnNoteClickListener): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    interface OnNoteClickListener{
        fun onNoteClike(note:Note)
        fun onNoteLongClick(note: Note)


    }

    inner class ViewHolder(private val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root){

        init{
            binding.apply{
                root.setOnClickListener{
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION){
                        val note = mNotes[position]
                        listener.onNoteClike(note)
                    }
                }
                root.setOnLongClickListener{
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION){
                        val note = mNotes[position]
                        listener.onNoteLongClick(note)
                    }
                    true
                }
            }
        }

        fun bind(note: Note){
                   binding.title.text = note.title
              binding.content.text =note.content
                   val formatter = SimpleDateFormat("dd/mm/yy")
              binding.date.text =formatter.format(note.date)




          }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       with(mNotes[position]){
           holder.bind(this)
       }
    }

    override fun getItemCount():Int{
          return mNotes.size
    }



    }

