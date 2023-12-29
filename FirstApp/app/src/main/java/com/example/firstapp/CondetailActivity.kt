package com.example.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CondetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condetail)

        val backButton = findViewById<ImageButton>(R.id.icon_back)
        backButton.setOnClickListener {
            finish()
        }

        // intent로부터 전달받은 데이터를 저장할 변수
        var name = intent.getStringExtra("name")
        var phone = intent.getStringExtra("phone")
        var email = intent.getStringExtra("email")
        var organization = intent.getStringExtra("organization")

        // 각 TextView에 데이터를 입력
        val nameTextView = findViewById<TextView>(R.id.person_name)
        val organizationTextView = findViewById<TextView>(R.id.person_institute)
        val phoneTextView = findViewById<TextView>(R.id.person_phone)
        val emailTextView = findViewById<TextView>(R.id.person_email)

        nameTextView.text = name
        organizationTextView.text = organization
        phoneTextView.text = phone
        emailTextView.text = email
    }
}