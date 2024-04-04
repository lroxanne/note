package com.example.note1.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note1.data.dao.NoteDao
import com.example.note1.data.entity.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}