package com.example.galleryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.galleryapp.base.BaseAdapter
import com.example.galleryapp.base.BaseViewHolder
import com.example.galleryapp.utils.Photo

class ImageAdapter : BaseAdapter() {

    var photoArray = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        setupGalleryViewHolder(holder as GalleryViewHolder, position)
    }

    private fun setupGalleryViewHolder(holder: GalleryViewHolder, position: Int){
        val item = photoArray[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return photoArray.size
    }
}

class GalleryViewHolder(itemView: View): BaseViewHolder(itemView){

    val image: ImageView = itemView.findViewById(R.id.iv_photo)

    fun bind(item: Photo) {
        Glide.with(image.context)
            .load(item.imagePath)
            .into(image)
    }
}