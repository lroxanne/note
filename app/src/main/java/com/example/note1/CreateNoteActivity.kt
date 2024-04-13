package com.example.note1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView
import com.example.note1.databinding.ActivityCreateNoteBinding

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.imageBack.setOnClickListener {
            finish()  // Close this activity and return to the previous one
        }

        binding.imageDone.setOnClickListener {
            saveNote()
        }

        // Optionally set up current date and time display
        binding.textDateTime.text = getCurrentDateTime()

        // Setup other UI elements as needed
    }

    private fun getCurrentDateTime(): String {
        // You can use SimpleDateFormat to format current date and time
        return "Current Date Time"
    }

    private fun saveNote() {
        val title = binding.inputNoteTitle.text.toString()
        val note = binding.inputNote.text.toString()
        // Save the note here using your preferred method (e.g., SharedPreferences, Database)
        // For now, we just finish the activity
        finish()
    }
}
