package com.example.firstapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        // Get the image resource ID from the intent
        val imageResourceId = intent.getIntExtra(EXTRA_IMAGE_RES_ID, 0)

        // Find the ImageView in the layout
        val imageViewDetail: ImageView = findViewById(R.id.imageViewDetail)

        // Set the larger image in the ImageView
        imageViewDetail.setImageResource(imageResourceId)
    }

    companion object {
        const val EXTRA_IMAGE_RES_ID = "extra_image_res_id"
    }
}
