package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.main_page)

        val navController = findNavController(R.id.nav_host_fragment)

        findViewById<Button>(R.id.btnContactPage).setOnClickListener {
            navController.navigate(R.id.action_main_to_contact)
        }

        findViewById<Button>(R.id.btnGalleryPage).setOnClickListener {
            navController.navigate(R.id.action_main_to_gallery)
        }

        findViewById<Button>(R.id.btnThirdPage).setOnClickListener {
            navController.navigate(R.id.action_main_to_third)
        }
    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}
