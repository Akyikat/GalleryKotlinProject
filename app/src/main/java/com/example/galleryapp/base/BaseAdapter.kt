package com.example.galleryapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>()

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)