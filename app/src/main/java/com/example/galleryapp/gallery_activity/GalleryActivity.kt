package com.example.galleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.galleryapp.utils.ImagesExtractor
import com.example.galleryapp.utils.PermissionClass
import com.example.galleryapp.utils.Photo

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ImageAdapter
    var images = mutableListOf<Photo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        PermissionClass(this).checkGalleryPermission()
        setupRecyclerView()
//        images = ImagesExtractor.listOfImages(this)
        print("Count of images is " + images.count())
    }

    private fun setupRecyclerView() {

    }
}