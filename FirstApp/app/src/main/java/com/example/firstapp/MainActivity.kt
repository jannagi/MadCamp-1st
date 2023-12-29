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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)

        val contactButton = findViewById<Button>(R.id.btnContactPage)
        val galleryButton = findViewById<Button>(R.id.btnGalleryPage)
        var thirdButton = findViewById<Button>(R.id.btnThirdPage)


        // 각 버튼에 대한 클릭 이벤트 처리
        contactButton.setOnClickListener {
            navigateToPage(ContactPage::class.java)
        }

        galleryButton.setOnClickListener {
            navigateToPage(GalleryPage::class.java)
        }

        thirdButton.setOnClickListener {
            navigateToPage(ThirdPage::class.java)
        }
    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}
