package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)

        val contactButton = findViewById<Button>(R.id.btnContactPage)
        val galleryButton = findViewById<Button>(R.id.btnGalleryPage)
        var thirdButton = findViewById<Button>(R.id.btnThirdPage)


        // 각 버튼에 대한 클릭 이벤트 처리
        contactButton.setOnClickListener {
            navigateToPage(ContactActivity::class.java)
        }

        galleryButton.setOnClickListener {
            navigateToPage(GalleryPage::class.java)
        }

        thirdButton.setOnClickListener {
            navigateToPage(CalendarPage::class.java)
        }
    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}
