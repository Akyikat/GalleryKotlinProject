package com.example.galleryapp.utils

import android.Manifest
import android.app.Activity
import androidx.core.app.ActivityCompat


class PermissionClass(private val activity: Activity) {

    fun checkGalleryPermission() {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            }
    }

}