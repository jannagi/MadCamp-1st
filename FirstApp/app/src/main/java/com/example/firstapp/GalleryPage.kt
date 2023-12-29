package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class GalleryPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery_page)

        val backButton = findViewById<ImageButton>(R.id.icon_back)
        backButton.setOnClickListener {
            navigateToPage(MainActivity::class.java)
        }

        // Initialize and set up your image gallery (GridView)
        val gridView: GridView = findViewById(R.id.gridView)
        val imageAdapter = ImageAdapter(this)
        gridView.adapter = imageAdapter

    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}