package com.example.firstapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val context: Context) : BaseAdapter() {

    private val dummyImages = intArrayOf(
        R.drawable.gallery_image_01,
//        R.drawable.gallery_image_02,
//        R.drawable.gallery_image_03,
//        R.drawable.gallery_image_04,
//        R.drawable.gallery_image_05,
//        R.drawable.gallery_image_06,
//        R.drawable.gallery_image_07,
//        R.drawable.gallery_image_08,
//        R.drawable.gallery_image_09,
//        R.drawable.gallery_image_10,

        // Add more dummy image resource IDs as needed
    )

    override fun getCount(): Int {
        return dummyImages.size
    }

    override fun getItem(position: Int): Any {
        return dummyImages[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(context)
            // Set layout parameters, scale type, etc.
        } else {
            imageView = convertView as ImageView
        }

        // Load and set the image for the current position
        imageView.setImageResource(dummyImages[position])

        return imageView
    }
}