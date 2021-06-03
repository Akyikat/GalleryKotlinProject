package com.example.galleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.utils.ImagesExtractor
import com.example.galleryapp.utils.PermissionClass
import com.example.galleryapp.utils.Photo
import kotlinx.android.synthetic.main.activity_gallery.*

class MainActivity : AppCompatActivity(), CLickListener {

    private var isEditing = true
    lateinit var adapter: ImageAdapter
    var images = mutableListOf<Photo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        getIntentData()
        PermissionClass(this).checkGalleryPermission()
        setupRecyclerView()
        setupImagesData()
        //Добавить нажатие на кнопку в нижней плашке
        print("Count of images is " + images.count())
    }

    private fun getIntentData() {
        //получить isEditing из intent
    }

    private fun setupRecyclerView() {
        adapter = ImageAdapter(this, isEditing)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
        images = ImagesExtractor.listOfImages(this)
        adapter.addItems(images)
    }

    private fun setupImagesData() {
        //получение данных взависимости от поля isEditing/ true = Extractor; false = intent
        //images = ImagesExtractor.listOfImages(this)
        adapter.addItems(images)
    }

    override fun onItemClick(sizeOfArray: Int) {
        setupBottomPanel(sizeOfArray)
    }

    private fun setupBottomPanel(size: Int) {
        num_selected.isVisible(size < 0)
        text_selected.text = "Выбрана $size фотография"

    }

    //функкия нажатия на кнопку btn_done
    //MainActivity.start(this, adapter.getSelectedArray())

    companion object {

    }
}