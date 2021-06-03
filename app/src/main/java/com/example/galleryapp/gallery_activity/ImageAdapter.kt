package com.example.galleryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.example.galleryapp.base.BaseAdapter
import com.example.galleryapp.base.BaseViewHolder
import com.example.galleryapp.utils.Photo
import kotlinx.android.synthetic.main.item_layout.view.*

class ImageAdapter(private val listener: CLickListener, private val isEditing: Boolean) : BaseAdapter() {

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
        if (isEditing)
        holder.itemView.setOnClickListener {
            if (getSizeImageArray() < 10 || photoArray[position].isSelected) {
                photoArray[position].isSelected = !photoArray[position].isSelected
                listener.onItemClick(getSizeImageArray())
                notifyItemChanged(position)
            }

        }
    }

    fun getSelectedArray() = photoArray.filter { it.isSelected }

    private fun getSizeImageArray() = getSelectedArray().size

    override fun getItemCount(): Int {
        return photoArray.size
    }

    fun addItems(items: MutableList<Photo>) {
        photoArray = items
        notifyDataSetChanged()
    }
}

interface CLickListener{
    fun onItemClick(sizeOfArray: Int)
}

class GalleryViewHolder(itemView: View): BaseViewHolder(itemView){

    val image: ImageView = itemView.findViewById(R.id.iv_photo)

    fun bind(item: Photo) {
        itemView.check_mark.isVisible(item.isSelected)
        itemView.selected_background.isVisible(item.isSelected)
        Glide.with(image.context)
            .load(item.imagePath)
            .into(image)
    }
}