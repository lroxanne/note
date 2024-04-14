package com.example.note1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.note1.dao.NoteDao
import com.example.note1.entities.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {
    private var notesDatabase: NoteDatabase? = null

    @Synchronized
    fun getNotesDatabase(context: Context?): NoteDatabase? {
        if (notesDatabase == null) {
            notesDatabase = Room.databaseBuilder(
                context!!,
                NoteDatabase::class.java,
                "notes_db"
            ).build()
        }
        return notesDatabase
    }
    abstract fun noteDao(): NoteDao
}
