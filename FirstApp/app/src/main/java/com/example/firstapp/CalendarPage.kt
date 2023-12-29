package com.example.firstapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class CalendarPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar_page)

        val backButton = findViewById<Button>(R.id.icon_back)
        backButton.setOnClickListener {
            navigateToPage(MainActivity::class.java)
        }

        val addMemoButton = findViewById<FloatingActionButton>(R.id.fab_add_memo)
        addMemoButton.setOnClickListener {
            // Open the MemoActivity to input a memo for the selected date
            val selectedDate = getCurrentDate()
            val intent = Intent(this, MemoActivity::class.java)
            intent.putExtra("selectedDate", selectedDate)
            startActivity(intent)
        }

    }

    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}